package ru.rumceiling.info;


import ru.rumceiling.info.model.Entyty;
import ru.rumceiling.info.service.ParsingRumceiling;

public class AppRunner {

	private static final String URL = "https://rumceiling.ru/fotogalereya/foto-tkanevye-natyazhnye-potolki/";
	private static final String PostURL = "https://rumceiling.ru/wp-admin/admin-ajax.php";
	public static void main(String[] args) {

		Entyty entity = ParsingRumceiling.getEntyty(URL);
		
		System.out.println(entity.getImg());
		
	}

}
