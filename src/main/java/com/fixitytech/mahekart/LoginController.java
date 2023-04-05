package com.fixitytech.mahekart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.UserDao;
@Controller
public class LoginController {
	@Autowired
	UserDao dao;
	
	@RequestMapping( value="/login", method=RequestMethod.GET)
    public String login() {
        
        
        return "Login";
    }
	
	
	
	@PostMapping( value="/login")
	public String welcome(Model m,HttpServletRequest request,HttpSession hs,String uname,String upassword,String cont) {
	   

      /*  String uname=request.getParameter("uname");
        String upassword=request.getParameter("upassword");
        String c=request.getParameter("cont");*/
        
        
        int n=dao.validate(uname,upassword);
        
        if(n!=0)
        {
        	
             hs=request.getSession(true);            
            hs.setAttribute("uid", uname);
            if(cont!=null && cont.length()>0)
                return "redirect:"+cont;
            else
            return "redirect:index";
            
        }
        else
        {
        	
        	if(uname.equals("admin") && upassword.equals("admin"))
            {
        		String admin="admin";
        		 hs=request.getSession(true); 
        		hs.setAttribute("uid",admin);
        	return "redirect:adminhome";
            }
        	else
        	{
            m.addAttribute("err"," invalid username or password");
            
            return "Login";
        	}
        }
        
    	   
	}	

}
	

