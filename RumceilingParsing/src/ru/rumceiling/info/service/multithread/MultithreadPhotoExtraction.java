package ru.rumceiling.info.service.multithread;

import java.util.List;

import org.jsoup.Connection;
import org.jsoup.nodes.Element;

import ru.rumceiling.info.service.FotoPageService;

public class MultithreadPhotoExtraction extends Thread {

	private final String navLink;
	
	public MultithreadPhotoExtraction(String navLink) {
		this.navLink = navLink;
	}
	
	@Override
	public void run() {
		Element postContentElement = FotoPageService.
				preparePostRedirectionElement(navLink);
		Connection postConnection = FotoPageService.preparePostConnectionFromElement(postContentElement);
		List<String> photoLinks = FotoPageService.getFileLinks(postConnection);
		
		// make download service
		
	}
}
