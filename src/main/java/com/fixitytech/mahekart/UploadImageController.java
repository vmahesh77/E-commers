package com.fixitytech.mahekart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@MultipartConfig(maxFileSize = 16177215)
public class UploadImageController {
	@RequestMapping( value="/uploadimage", method=RequestMethod.POST)
    public String uploadImage(HttpServletRequest request) {
		
		try
		{
		
		  String itemname = request.getParameter("itemName");
	        int itemid=Integer.parseInt(request.getParameter("Id"));
	        double itemprice = Double.parseDouble(request.getParameter("itemPrice"));
	        Part filePart = request.getPart("image");
	        String imagefilename=filePart.getSubmittedFileName();
	        
	        HttpSession hs=request.getSession();
	       
	        String uploadPath =hs.getServletContext().getRealPath("imageuploading");
	        File f=new File(uploadPath);
	        System.out.println(f.getAbsoluteFile());
	        System.out.print(uploadPath);
	        String destination=uploadPath+"/"+itemid;
	        
	        
	        File file=new File(destination);
	        file.mkdirs();
	        InputStream inputFile=filePart.getInputStream();
	        FileOutputStream outputFile=new FileOutputStream(destination+"\\"+imagefilename);
	        byte b[]=new byte[1024];
	        int noOfBytes=0;
	        while((noOfBytes=inputFile.read(b))>0) {
	            outputFile.write(b, 0, noOfBytes);
	        }
	        inputFile.close();
	        outputFile.close();
	        
	        
	        
	        
	    }
		
	        catch (Exception e) 
		{
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        
	        
	        
	        
	        
	        
	        
	     return "redirect:adminhome";   
	    



	}
    }
		


