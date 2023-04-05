package com.fixitytech.mahekart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.UserDao;
@Controller
public class ProfileController {
@Autowired
UserDao userDao;
@RequestMapping( value="/profile", method=RequestMethod.GET)
public String profile(HttpServletRequest request) {
	HttpSession hs=request.getSession(true);
	String uid=(String)hs.getAttribute("uid");
	   User user=userDao.getUser(uid);
	if(user!=null)
	{
	    request.setAttribute("user",user);
	     return "Profile";//jsp
	       
	         
	}
	else
	  return "MyAccount?msg please login";//jsp
}


       
}
