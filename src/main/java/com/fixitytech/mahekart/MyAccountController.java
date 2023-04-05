package com.fixitytech.mahekart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyAccountController {
	@RequestMapping( value="/myaccount", method=RequestMethod.GET)
    public String login() {
        
        
		return "MyAccount";//jsp
    }
}
