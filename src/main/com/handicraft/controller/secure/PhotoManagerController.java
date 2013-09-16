package com.handicraft.controller.secure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.handicraft.controller.ParentMultiAction;
import com.handicraft.util.Codes;
import com.handicraft.util.ProjectProperty;

//TODO move all the logic to service
public class PhotoManagerController extends ParentMultiAction {
	Log log = LogFactory.getLog(PhotoManagerController.class);
	private String photoLocation =ProjectProperty.getValue("IMAGE_LOCATION");
	
	public ModelAndView upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MultipartHttpServletRequest reqt = (MultipartHttpServletRequest)request;  
        MultipartFile file = reqt.getFile("uploadFile");  
        String filename = file.getOriginalFilename();
        
        if(!StringUtils.isEmpty(request.getParameter("newName"))){
        	filename = request.getParameter("newName");
        }
        
        //TODO check size, validate file, max size?
        log.debug("File size = " + file.getSize());
        log.debug("Original file name = " + file.getOriginalFilename());
        log.debug("New file name = " + filename);
        
        Map<String,String> resultMap = new HashMap<String,String>();
        
        
        if(file != null) {  
        	try{
            	File dest = new File(photoLocation + filename.toLowerCase());
            	file.transferTo(dest);
        	}catch(Exception e){
        		resultMap.put("result", "Failed");	
        	}
        	resultMap.put("result", "Added");	
        }else {
        	resultMap.put("result", "Failed");
        }
        return new ModelAndView("uploadPhoto",resultMap);
	}
	
	public ModelAndView showImages(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,List<String>> resultMap = new HashMap<String,List<String>>();

        List<String> fileNames = new ArrayList<String>();
        
        File photoDir = new File(photoLocation);
        File[] files = photoDir.listFiles();
        for(File file : files){
        	fileNames.add(file.getName());
        }
        
        Collections.sort(fileNames);//sort by name
        
        resultMap.put("files",fileNames);
        
        return new ModelAndView("viewPhotos",resultMap);
	}
	
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

	public ModelAndView deletePhoto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String image = request.getParameter("imageId");
		File f = new File (photoLocation + image);
		try{
			f.delete();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return showImages(request,response);
	}

	public ModelAndView showEditPhoto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String image = request.getParameter(Codes.VAR_IMAGE_ID);
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("oldName", image);
        return new ModelAndView("editPhoto",resultMap);
	}

	public ModelAndView renamePhoto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String newName = request.getParameter("newName");
		String oldName = request.getParameter("oldName");
		//TODO check file existence
		File f = new File(photoLocation + oldName);
	    try{
	    	f.renameTo(new File(photoLocation + newName));
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
        return showImages(request,response);
	}
}