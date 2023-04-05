package com.fixitytech.mahekart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.OrderDao;
@Controller
public class MyOrderController {
@Autowired
OrderDao orderDao;
@RequestMapping( value="/myorder", method=RequestMethod.GET)
public String myOrder(HttpServletRequest request) {
	HttpSession hs=request.getSession(true);
	String uid=(String)hs.getAttribute("uid");
	List<Order> orders=orderDao.viewOrders(uid);
	
	if(orders!=null)
	{
	request.setAttribute("orders",orders);
	return "MyOrders";//jsp

	}
	else
		return "MyAccount";//jsp
}



}
