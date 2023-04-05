package com.fixitytech.mahekart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.OrderDao;
@Controller
public class SucessController {
@Autowired
OrderDao orderDao;
	
	@RequestMapping( value="/sucess", method=RequestMethod.GET)
    public String sucess(Model m) {
        
		 List<Order> orders=orderDao.sucessOrders("accept");
	        
	        if(orders!=null)
	        {
	       m.addAttribute("orders",orders);
	       return "Sucess";//jsp
	    
	        }
	        else
	            return "MyAccount";//jsp
    }
	
}
