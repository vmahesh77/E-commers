package com.fixitytech.mahekart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.UserDao;
@Controller
public class RegisterController {
	@Autowired
	UserDao userdao;
	@RequestMapping( value="/register", method=RequestMethod.GET)
    public String register() {
        
        
        return "Register";//jsp
    }
	
	
	@RequestMapping( value="/register", method=RequestMethod.POST)
    public String register(HttpServletRequest request,Model m,User user) {
        
		/*String uname=request.getParameter("uname");
		String upassword=request.getParameter("upassword");
		String ufullname=request.getParameter("fullname");
		String umobilenumber=request.getParameter("mobilenumber");
		String uemail=request.getParameter("email");*/
		
		  User users =new User();
          users.setUname(user.uname);
          users.setUpassword(user.upassword);
          users.setFullname(user.fullname);
          users.setMobilenumber(user.mobilenumber);
          users.setEmail(user.email);
          
		
		boolean b=userdao.save(user);
	
		
		if(b)
		{
			HttpSession hs=request.getSession(true);
			hs.setAttribute("uid", user.uname);
			return "redirect:index";
			
		}
		else
		{
			request.setAttribute("err"," pls try again later!");
			return "redirect:register";
		}
		
		
	}
    }
	
	

