package com.fixitytech.mahekart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.UserDao;

@Controller
public class UpdateUserController {
@Autowired
UserDao userDao;

@RequestMapping( value="/UpdateUser", method=RequestMethod.GET)
public String updateUser(Model m,HttpServletRequest request) {
    
	HttpSession hs=request.getSession(true);
    String uid=(String)hs.getAttribute("uid");
       User user=userDao.getUser(uid);
   if(user!=null)
   {
        m.addAttribute("user",user);
           return "updateuser";        
            
   
    }
return "index";
}

@RequestMapping( value="/UpdateUser", method=RequestMethod.POST)
public String updateUser(Model m,HttpServletRequest request,HttpServletResponse response) {
    
	String uname=request.getParameter("uname");
    String upassword=request.getParameter("upassword");
    String ufullname=request.getParameter("fullname");
    String umobilenumber=request.getParameter("mobilenumber");
    String uemail=request.getParameter("email");
    
    User user= new User();
    
    user.setUname(uname);
    user.setUpassword(upassword);
    user.setFullname(ufullname);
    user.setMobilenumber(umobilenumber);
    user.setEmail(uemail);
    
    
    boolean b=userDao.update(user);

    
    if(b)
    {
        HttpSession hs=request.getSession(true);
        hs.setAttribute("uid", uname);
        return "Home";
        
    }
    else
    {
        m.addAttribute("err"," pls try again later!");
        return "redirect:Updateuser";
    }
  
    
}
}

