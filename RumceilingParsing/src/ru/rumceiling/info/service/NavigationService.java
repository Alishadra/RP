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
			Elements liElements = galeryElement.getElementsByTag("li");

			for (Element liElement : liElements) {
				Elements aElements = liElement.getElementsByTag("a");
				for (Element aElement : aElements) {
					navigationLinks.add(aElement.attr("href"));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return navigationLinks;
	}

}
