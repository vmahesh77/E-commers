package com.fixitytech.mahekart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.OrderDao;
@Controller
public class RejectOrderController {
@Autowired
OrderDao orderDao;
@RequestMapping( value="/rejectorder", method=RequestMethod.GET)
public String rejectOrder(HttpServletRequest request) {
    
	int OrderId=Integer.parseInt(request.getParameter("orderId"));
	
	HttpSession hs=request.getSession(true);
	boolean accept=orderDao.rejectOrders(OrderId);
	if(accept)
		return "redirect:PendingOrders";
	else
		return "redirect:vieworder";
}
}



