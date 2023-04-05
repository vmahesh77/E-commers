package com.fixitytech.mahekart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

	
	@RequestMapping( value="/logout", method=RequestMethod.GET)
    public String logout( HttpSession hs, HttpServletRequest request ) {
        
          hs=request.getSession(true);  
            hs.invalidate();
            
        return "redirect:index";
    }
}
