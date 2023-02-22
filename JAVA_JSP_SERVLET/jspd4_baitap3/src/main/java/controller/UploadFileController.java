package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tomcat.jakartaee.commons.compress.utils.FileNameUtils;
@MultipartConfig
public class UploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UploadFileController() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");

	    // Create path components to save the file
	    final String path = request.getServletContext().getRealPath("files"); //thư mục lưu trữ
	    final Part filePart = request.getPart("file-img");
	    final String fileName = getFileName(filePart);
	    File dirFileUpload = new File(path);
	    if(!dirFileUpload.exists()) {
	    	dirFileUpload.mkdir();
	    }
	    if(fileName != "") {
	    final String renameFile = renameFile(fileName);
	    System.out.println(path);
	    OutputStream out = null;
	    InputStream filecontent = null;
	    try {
	        out = new FileOutputStream(new File(path + File.separator + renameFile));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }	      
	    } catch (FileNotFoundException fne) {
	        fne.printStackTrace();
	        response.sendRedirect(request.getContextPath() + "/show-upload-file?msg=1");
	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	    }
	    request.setAttribute("filename", renameFile);
	    RequestDispatcher rd = request.getRequestDispatcher("/uploadfile.jsp");
	    rd.forward(request, response);
	    }else {
	    	response.sendRedirect(request.getContextPath() + "/show-upload-file?msg=2");
	    }
	    //System.out.println("Upload file thành công");
	   
	}

	private String getFileName(final Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
	public String renameFile(String file) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		Date date = new Date();
		return FileNameUtils.getBaseName(file) + "_" + sdf.format(date) + "." + FileNameUtils.getExtension(file);
	}

}
