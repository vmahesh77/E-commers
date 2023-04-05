package com.fixitytech.mahekart;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fixitytech.mahekart.repository.ItemDao;

@Controller
public class AddCartController {
	@Autowired
	ItemDao itemdao;
	@RequestMapping( value="/addcart", method=RequestMethod.GET)
	public String AddCart(HttpServletRequest request,HttpServletResponse response)
	{
int id=Integer.parseInt(request.getParameter("id"));
        
        HttpSession hs=request.getSession(true);
        
        List<CartItem> cart=(List<CartItem>)hs.getAttribute("cart");
        
        if(cart==null)
            cart=new Vector<CartItem>();
        boolean f=false;
        for(CartItem citem: cart) {
            if(citem.getId()==id) {
                citem.setQuantity(citem.getQuantity()+1);
                f=true;
                break;
            }
            }
            
        if(!f)
        {
         Item item =itemdao.getItem(id);
         if(item!=null)
         {
             CartItem cartItem=new CartItem();
             cartItem.setId(item.getId());
             cartItem.setName(item.getName());
             cartItem.setPrice(item.getPrice());
             cartItem.setQuantity(1);
             cart.add(cartItem);
         }
        }
         hs.setAttribute("cart",cart);
         return "redirect:index";
             
	}

}
