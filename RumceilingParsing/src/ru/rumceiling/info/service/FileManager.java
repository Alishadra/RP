package ru.rumceiling.info.service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class FileManager {
	
	
	public static boolean writeNavigationLinks(NavigationService navigationLinks, boolean append) {
		
		try (BufferedInputStream wr = new BufferedInputStream(new URL(FILE_URL).openStream());
				FileOutputStream fileOutputStream = new FileOutputStream("foto")){
					byte dataBuffer[] = new byte[1024];
					int byteRead;
					while ((byteRead = in.read(dataBuffer, 0, 1024)) != -1) {
						FileInputStream.write(dataBuffer, 0, byteRead);
					}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
//
//	try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
//			  FileOutputStream fileOutputStream new FileOutputStream(FILE_NAME)) {
//			    byte dataBuffer[] = new byte[1024];
//			    int bytesRead;
//			    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
//			        fileOutputStream.write(dataBuffer, 0, bytesRead);
//			    }
//			} catch (IOException e) {
//			    // handle exception
//			}
}
