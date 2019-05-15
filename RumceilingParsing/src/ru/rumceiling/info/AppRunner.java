package ru.rumceiling.info;

import ru.rumceiling.info.service.FileManager;
import ru.rumceiling.info.service.FotoPageService;
import ru.rumceiling.info.service.NavigationService;

public class AppRunner {

	private static final String FILE_URL = "C:\\Users\\HOME\\Desktop";

	public static void main(String[] args) {
		
	FotoPageService fotoPageService = new FotoPageService();
	fotoPageService.preparePostConnection(FILE_URL);
	
	NavigationService navigationService = new NavigationService();
	navigationService.getNavigationLinks();
	
	FileManager fileManager = new FileManager();
	fileManager.writeNavigationLinks(navigationService, true);

	}

}
