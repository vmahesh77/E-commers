package com.fixitytech.mahekart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.OrderDao;

@Controller
public class PendingOrderController {
@Autowired
OrderDao orderDao;

@RequestMapping( value="/pendingorder", method=RequestMethod.GET)
public String pendingOrder(HttpServletRequest request) {
	List<Order> orders=orderDao.pendingOrders("pending");
    
    if(orders!=null)
    {
    request.setAttribute("orders",orders);
    return "PendingOrders";//jsp
   
    }
    else
        return "MyAccount";//jsp
}
	
	
	
	
	
	
	
	
	
	
}
