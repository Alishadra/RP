package ru.rumceiling.info.service;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class FileManager {
	
	private static final String DIR_PATH = "C:\\Users\\HOME\\Desktop\\"; 
	
	public static synchronized void writeNavigationLinks(String photoLinks) {
		
		
		String fileName = StringUtils.substringAfterLast(photoLinks, "/");
		
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(photoLinks).openStream());
				FileOutputStream fileOutputStream = new FileOutputStream(DIR_PATH + fileName)){
					byte dataBuffer[] = new byte[1024];
					int byteRead;
					while ((byteRead = bufferedInputStream.read(dataBuffer, 0, 1024)) != -1) {
						fileOutputStream.write(dataBuffer, 0, byteRead);
					}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
