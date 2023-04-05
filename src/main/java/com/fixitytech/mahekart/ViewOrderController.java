package com.fixitytech.mahekart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.OrderDao;
@Controller
public class ViewOrderController {
@Autowired
OrderDao orderdao;


@RequestMapping( value="/vieworder", method=RequestMethod.GET)
public String viewOrder(Model m) {
	List<Order> orders=orderdao.viewOrders();
	 
	 if(orders!=null)
       {
       m.addAttribute("orders",orders);
       return "ViewAllOrders";//jsp
    
       }
       else
           return "redirect:adminhome";
   }

}


