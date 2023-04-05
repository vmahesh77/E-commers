package com.fixitytech.mahekart;

import java.io.File;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@MultipartConfig
@Controller
public class ImageRemoveController {
	@RequestMapping( value="/imageremove", method=RequestMethod.GET)
    public String imageRemove(HttpServletRequest request) {
        
		String id=request.getParameter("itemid");
        String image=request.getParameter("itemname");
        HttpSession hs=request.getSession();
        String uploadPath =hs.getServletContext().getRealPath("imageuploading");
        String destinationpath=uploadPath+File.separator+id+File.separator+image;
        System.out.print(destinationpath);
        File f=new File(destinationpath);
        
            f.delete();
            return "Admin";//jsp
            
    }
}
