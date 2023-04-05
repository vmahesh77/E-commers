package com.fixitytech.mahekart;




import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fixitytech.mahekart.repository.ItemDao;


@Controller


public class IndexController { 
@Autowired
ItemDao itemdao;
@Autowired
ServletContext context;

@RequestMapping("/index")
public String welcome(Model m,HttpSession hs,HttpServletRequest request) {
   
	hs=request.getSession(true);
    
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
    m.addAttribute("prs", products);
  
   
	
    return "Index";
}


}



