package ru.rumceiling.info.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FotoPageService {

	public static Element preparePostRedirectionElement(String navLink) {
		// the first step - get document with link, where photo links are present
		Document document;
		try {
			document = Jsoup.connect(navLink).get();
			Elements elements = document.getElementsByAttributeValue("data-vc-request",
					"https://rumceiling.ru/wp-admin/admin-ajax.php");
			if (!elements.isEmpty()) {
				return elements.first();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static Connection preparePostConnectionFromElement(Element element) {

		if (element == null) {
			return null;
		}
		// the second step - create connection with params to make POST request

		String postURL = element.attr("data-vc-request");
		Connection postConnection = Jsoup.connect(postURL);
		// set headers
		postConnection.header("accept", "text/html, */*; q=0.01");
		postConnection.header("accept-encoding", "gzip, deflate, br");
		postConnection.header("accept-language", "uk,ru-RU;q=0.9,ru;q=0.8,en-US;q=0.7,en;q=0.6");
		postConnection.header("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
		postConnection.header("x-requested-with", "XMLHttpRequest");

		// set params

		String settings = element.attr("data-vc-grid-settings");
		settings = settings.replaceAll("&quot;", "\"");
		JSONObject setingsJson = new JSONObject(settings);

		Map<String, String> params = getParams(setingsJson);

		for (String key : params.keySet()) {
			postConnection.data("data[" + key + "]", params.get(key));

			if (key.equals("page_id")) {
				postConnection.data("vc_post_id", params.get(key));
			}
			if (key.equals("action")) {
				postConnection.data("vc_action", params.get(key));
				postConnection.data("action", params.get(key));
			}
			if (key.equals("tag")) {
				postConnection.data("tag", params.get(key));
			}
		}

		postConnection.data("data[visible_pages]", "5");
		postConnection.data("_vcnonce", element.attr("data-vc-public-nonce"));

		return postConnection;
	}

	private static Map<String, String> getParams(JSONObject setingsJson) {

		Map<String, String> params = new HashMap<String, String>();

		Iterator<String> keysItr = setingsJson.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			String value = (String) setingsJson.get(key);
			params.put(key, value);
		}

		return params;
	}

	public static List<String> getFileLinks(Connection connection) {
		
		List<String> fileLinks = new ArrayList<String>();
		
		if (connection == null) {
			return fileLinks;
		}

		try {
			Document document = connection.post();
			Elements imgElements = document.getElementsByTag("img");
			for (Element element : imgElements) {
				if (element.hasAttr("src") && element.hasAttr("class")
						&& element.attr("class").equals("vc_gitem-zone-img")) {
					fileLinks.add(element.attr("src"));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileLinks;
	}

}
