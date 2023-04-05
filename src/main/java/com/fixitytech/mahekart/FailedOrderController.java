package com.fixitytech.mahekart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.OrderDao;

@Controller
public class FailedOrderController {

	@Autowired
	OrderDao orderDao;
	@RequestMapping( value="/failedorder", method=RequestMethod.GET)
    public String failedOrder(HttpServletRequest request) {
        
		
		 List<Order> orders=orderDao.failedOrders("reject");
         
         if(orders!=null)
         {
         request.setAttribute("orders",orders);
         return "Failed.jsp";
        
         }
         else
             return "MyAccount";
        
        
    }
	
	
}
