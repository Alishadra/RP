package ru.rumceiling.info.service;

import java.io.IOException;
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
			entity.setImg(getImg(document));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return entity;

	}

	private static String getImg(Document document) {
		Elements artElements = document.getElementsByTag("link");
		for (Element element : artElements) {
			if(element.hasAttr("rel") && element.hasAttr("href") && element.attr("rel").equals("canonical")) {
				return element.attr("href");
			}
		
		return "";
	
		
	}
		return "";
		}

}
