package com.fixitytech.mahekart;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.OrderDao;
@Controller
public class OrderController {
@Autowired	
OrderDao orderdao;


@RequestMapping( value="/order", method=RequestMethod.GET)
public String order(HttpServletRequest request,HttpServletRequest response) {
	HttpSession hs=request.getSession();
    List<CartItem> cart=(List<CartItem>)hs.getAttribute("cart");
    String uid=(String)hs.getAttribute("uid");
    
    if(cart!=null)
    {
        double total=0;
    List<OrderItem> orderItems=new Vector<OrderItem>();
    for(CartItem citem:cart)
    {
        orderItems.add(new OrderItem(citem));
        total=total+citem.getPrice()*citem.getQuantity();
    }
    Order order=new Order();
    order.setBill(total);
    order.setUserId(uid);
    order.setOrderItems(orderItems);
    
    int b=orderdao.addOrder(order);
     if(b!=-1)
     {
                    
            hs.setAttribute("orderid",b);
         return "Home";//jsp
    }
     else
     {
         return "ViewCart?msg=pls try again later";//jsp
     }
     }
    else
      return "redirect:Index";
    
}
}
