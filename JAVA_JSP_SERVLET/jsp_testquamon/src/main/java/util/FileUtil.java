package util;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
@MultipartConfig 
public class FileUtil {
	public static String upload(String nameInput, HttpServletRequest request) throws IOException, ServletException{
		Part filePart = request.getPart(nameInput);
		String fileName = filePart.getSubmittedFileName();
		if(!fileName.equals("")) {
			String dirPath = request.getServletContext().getRealPath("admin/images/bds");
			File saveDir = new File(dirPath);
			if(!saveDir.exists()) {
				saveDir.mkdirs();
			}
			String filePath = dirPath + File.separator + fileName;
			filePart.write(filePath);
		}		
		return fileName;
	}
	
}
