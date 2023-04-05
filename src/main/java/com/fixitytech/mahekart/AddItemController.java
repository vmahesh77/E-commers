package com.fixitytech.mahekart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.ItemDao;
@Controller
@MultipartConfig(maxFileSize = 16177215)

public class AddItemController {
	@Autowired
	ItemDao itemdao;
	@RequestMapping( value="/additem", method=RequestMethod.GET)
	public String addItem()
	{
		return "AddItems";//jsp
	}
	
	@RequestMapping( value="/additem", method=RequestMethod.POST)
	public String addItem(Model m,HttpServletRequest request,HttpSession hs,Item item,Part photo)
	{
		
		try
		{
		/*int itemid = Integer.parseInt(request.getParameter("Itid"));
        String itemname = request.getParameter("uname");
        double itemprice = Double.parseDouble(request.getParameter("uprice"));*/
			String imagefilename=photo.getSubmittedFileName();
	        
	         hs=request.getSession();
	       
	        String uploadPath =hs.getServletContext().getRealPath("imageuploading");
	        File f=new File(uploadPath);
	        System.out.println(f.getAbsoluteFile());
	        System.out.print(uploadPath);
	        String destination=uploadPath+"/"+item.id;
        
        
	        File file=new File(destination);
	        file.mkdirs();
	        InputStream inputFile=photo.getInputStream();
	        FileOutputStream outputFile=new FileOutputStream(destination+"\\"+imagefilename);
	        byte b[]=new byte[1024];
	        int noOfBytes=0;
	        while((noOfBytes=inputFile.read(b))>0) {
	            outputFile.write(b, 0, noOfBytes);
	        }
	        inputFile.close();
	        outputFile.close();
	        
	        
	      boolean c=itemdao.save(item);
	      if(c)
	      {
	         
	          
	          m.addAttribute("success","one item added sucessfully");
          return "AddItems";//jsp
         
            
            
         
      }
        }
        catch(FileNotFoundException e) {
            // TODO: handle exception
            e.fillInStackTrace();
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return "AddItems";
    }
	 
	}

