package com.fixitytech.mahekart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.OrderDao;
@Controller
public class AcceptOrderController {
	@Autowired
	OrderDao orderDao;
	
	
	@RequestMapping( value="/acceptorder", method=RequestMethod.POST)
	public String acceptOrder(HttpServletRequest request)
	{
		int OrderId=Integer.parseInt(request.getParameter("orderId"));	
		HttpSession hs=request.getSession(true);
	     boolean accept=orderDao.acceptOrders(OrderId);
	     if(accept)
	         return "redirect:pendingorder";
	     else
	         return "redirect:vieworder";
	}
	 
     
     

}
