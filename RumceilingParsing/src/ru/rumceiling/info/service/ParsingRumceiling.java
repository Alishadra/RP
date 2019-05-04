package ru.rumceiling.info.service;

import java.awt.HeadlessException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.rumceiling.info.model.Entyty;

public class ParsingRumceiling {

	public static Entyty getEntyty(String URL) {
		Entyty entity = new Entyty();
		Document document = null;

		try {
			document = Jsoup.connect(URL).get();
			document = (Document) Jsoup.connect("PostURL")
					.header("access-control-allow-credentials", "true")
					.header("cache-control", "no-cache, must-revalidate, max-age=0")
					.header("Accept", "text/html, */*; q=0.01")
					.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
					.header("Origin", "https://rumceiling.ru")
					.header("Referer", "https://rumceiling.ru/fotogalereya/foto-tkanevye-natyazhnye-potolki/")
					.header("X-Requested-With", "XMLHttpRequest")
					.header("data-vc-grid-settings", "{&quot;page_id&quot;:1680,&quot;style&quot;:&quot;all&quot;,&quot;action&quot;:&quot;vc_get_vc_grid_data&quot;,&quot;shortcode_id&quot;:&quot;1540975798992-f20d85f5-6b46-5&quot;,&quot;tag&quot;:&quot;vc_media_grid&quot;}")
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36")
					.referrer("https://rumceiling.ru")
					.post();
			
			entity.setImg(getImg((Connection) document));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return entity;

	}

	private static String getImg(Connection document) {
		Elements artElements = ((Element) document).getElementsByTag("img");
		for (Element element : artElements) {
			if (element.hasAttr("src") && element.hasAttr("class") && element.attr("class").equals("vc_gitem-zone-img")) {
				return element.attr("src");
			}

			return "";

		}
	return"";
}

}
