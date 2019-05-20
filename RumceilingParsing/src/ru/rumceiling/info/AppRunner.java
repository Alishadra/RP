package ru.rumceiling.info;

import java.util.List;

import ru.rumceiling.info.service.NavigationService;
import ru.rumceiling.info.service.multithread.MultithreadPhotoExtraction;

public class AppRunner {

	public static void main(String[] args) {

		List<String> navLinks = NavigationService.getNavigationLinks();
		for (String navLink : navLinks) {
			MultithreadPhotoExtraction photoExtraction = new MultithreadPhotoExtraction(navLink);
			photoExtraction.start();
		}
		
	}
}
