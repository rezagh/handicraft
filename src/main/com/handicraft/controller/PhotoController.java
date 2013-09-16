package com.handicraft.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.handicraft.util.Codes;
import com.handicraft.util.ProjectProperty;

public class PhotoController extends ParentMultiAction{
	private String photoLocation =ProjectProperty.getValue("IMAGE_LOCATION");
	
	public void getImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String image = request.getParameter(Codes.VAR_IMAGE_ID);
		
		File file = new File(photoLocation + image);
		InputStream is = new FileInputStream(file);
	    
        // Get the size of the file
        long length = file.length();
    
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
    
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];
    
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }
    
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }
    
        // Close the input stream and return bytes
        is.close();
        
 		response.setContentType("image/jpeg");
		response.setContentLength(bytes.length);
		response.getOutputStream().write(bytes);
		response.flushBuffer();
	}

}
