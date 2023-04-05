package com.fixitytech.mahekart;

import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.AdminDao;
import com.fixitytech.mahekart.repository.ItemDao;
@Controller
public class AdminController {
	@Autowired
	AdminDao dao;
	@Autowired
	ItemDao itemdao;
	@Autowired
	ServletContext context;
	@RequestMapping( value="/adminhome", method=RequestMethod.GET)
    public String adminHome(HttpServletRequest request,HttpServletResponse response) {
HttpSession hs=request.getSession(true);
        
        List<CartItem> cart=(List<CartItem>)hs.getAttribute("cart");
        
        if(cart==null)
            cart=new Vector<CartItem>();
        hs.setAttribute("cart",cart);
        
        List<Item> products=itemdao.getItems();
       
        String uploadPath=context.getRealPath("imageuploading");
        
        for(Item item:products)
        {
             String destinationpath=uploadPath+File.separator+item.getId();
             File f=new File(destinationpath);
             
            String arr[]=f.list();
           if(arr!=null) {
           String image[]=new String[arr.length];
          
          
           if(arr.length>0)
           {
               for(int i=0;i<arr.length;i++)
              image[i]="imageuploading"+File.separator+item.getId()+File.separator+arr[i];
               
           }
         
          
           item.setBase64Image(image);
            
           }
        }
        request.setAttribute("prs", products);
       ;
        return "Admin";//jsp
       
     
        
       
    }
	
	@RequestMapping( value="/adminhome", method=RequestMethod.POST)
    public String adminHome(HttpServletRequest request) {
        
	    String Itid=request.getParameter("Itid");
	    String uname=request.getParameter("uname");
        String uprice=request.getParameter("uprice");
        String uimage=request.getParameter("uimage");
        
       int f=dao.uploadData(Itid,uname,uprice,uimage);
       if(f!=0)
       {
    	   return "redirect:index";
       }
       else
       {
    	   return "redirect:index";
       }

     
    }

}
