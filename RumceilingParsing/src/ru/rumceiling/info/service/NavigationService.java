package ru.rumceiling.info.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NavigationService {

	private static final String BASE_URL = "https://rumceiling.ru";

	public static List<String> getNavigationLinks() {
		List<String> navigationLinks = new ArrayList();
		try {
			Document document = Jsoup.connect(BASE_URL).get();

			Element galeryElement = document.getElementById("nav-menu-item-1714");
			Elements menuElements = galeryElement.getElementsByTag("a");

			for (Element linkElement : menuElements) {
				if (linkElement.hasAttr("href")) {

					navigationLinks.add(linkElement.attr("href"));
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return navigationLinks;
	}

}
