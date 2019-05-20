package ru.rumceiling.info.service;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;

public class FileManager {
	
	private static final String DIR_PATH = "your/dir/"; //TODO set dir
	
	public static synchronized void writeNavigationLinks(String photoLink) {
		
		String fileName = StringUtils.substringAfterLast(photoLink, "/");
		
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(photoLink).openStream());
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
