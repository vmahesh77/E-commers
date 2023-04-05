package com.fixitytech.mahekart;


	
	import java.io.File;

	import javax.servlet.ServletContext;
	import javax.servlet.annotation.MultipartConfig;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

	import com.fixitytech.mahekart.repository.ItemDao;

	@Controller
	@MultipartConfig
	public class ImageAddController {
	@Autowired
	ItemDao itemdao;
	@Autowired
	ServletContext context;
	@RequestMapping( value="/imageadding", method=RequestMethod.GET)
	public String imageAdding(HttpServletRequest request,Model m) {
	    
		int id=Integer.parseInt(request.getParameter("id"));
	    
	    HttpSession hs=request.getSession(true);
	    Item item=itemdao.getItem(id);
	    
	    String uploadPath=context.getRealPath("imageuploading");
	    String destinationpath=uploadPath+File.separator+item.getId();
	    File f=new File(destinationpath);
	    
	   String arr[]=f.list();
	   String image[]=new String[arr.length];
	  if(arr.length>0)
	  {
	      for(int i=0;i<arr.length;i++)
	       image[i]="imageuploading"+File.separator+item.getId()+File.separator+arr[i];
	      
	    
	    
	}
	  //item.setImage(image);
	  item.setBase64Image(image);
	  
	  m.addAttribute("items", item);
	  //Item products=itemdao.getItem("tv");
	  //request.setAttribute("prs", products);
	  return "addimage";
	 
	  
	}
	}


