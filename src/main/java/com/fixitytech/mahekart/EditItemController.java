package com.fixitytech.mahekart;

import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.ItemDao;

@Controller
public class EditItemController {
	@Autowired
	ItemDao itemdao;
	@Autowired
	ServletContext context;
	
	@RequestMapping( value="/edititem", method=RequestMethod.GET)
    public String login(HttpServletRequest request,Model m) {
    int id=Integer.parseInt(request.getParameter("id"));
		
		Item item =itemdao.getItem(id);
       
HttpSession hs=request.getSession(true);
        
        List<CartItem> cart=(List<CartItem>)hs.getAttribute("cart");
        
        if(cart==null)
            cart=new Vector<CartItem>();
        hs.setAttribute("cart",cart);
        
        
       
        String uploadPath=context.getRealPath("imageuploading");
        
       
             String destinationpath=uploadPath+File.separator+item.getId();
             File f=new File(destinationpath);
             
            String arr[]=f.list();
           if(arr!=null)
           {
           String image[]=new String[arr.length];
          // System.out.print(destinationpath+File.separator+arr[]);
          
           if(arr.length>0)
           {
               for(int i=0;i<arr.length;i++)
              image[i]=arr[i];
               
               
           }
         
          
           item.setBase64Image(image);
            
           }
        
  
        
          
        
        
        
        m.addAttribute("item", item);
        
       return "edititem";
       
    }
}
