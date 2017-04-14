/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.controlleruser;

import dicky.entities.Item;
import dicky.entities.Orders;
import dicky.entities.OrdersDetail;
import dicky.entities.OrdersDetailId;
import dicky.services.AccountService;
import dicky.services.OrdersDetailService;
import dicky.services.OrdersService;
import dicky.services.ProductService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dicky-java
 */
@Controller
@RequestMapping("cart")
public class CartController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private OrdersService ordersService;
    
    @Autowired
    private OrdersDetailService ordersDetailService;
    
    @Autowired
    private AccountService accountService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.put("title", "Pembelian Barang");
        return "cart.index";
    }
    
    @RequestMapping(value = "buy/{idProduct}", method = RequestMethod.GET)
    public String buy(@PathVariable("idProduct") String idProduct, HttpSession session, ModelMap modelMap){
        modelMap.put("title", "Pembelian Barang");
        if(session.getAttribute("cart") == null){
            List<Item> cart=new ArrayList<Item>();
            cart.add(new Item(productService.findId(idProduct), 1));
            session.setAttribute("cart", cart);
        }else{
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = isExsist(idProduct, session);
            if(index == -1){
                cart.add(new Item(productService.findId(idProduct), 1));
            }else{
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
                session.setAttribute("cart", cart);
            }
            session.setAttribute("cart", cart);
        }
        return "cart.index";
    }
    
    @RequestMapping(value = "delete/{index}", method = RequestMethod.GET)
    public String delete(@PathVariable("index") int index, HttpSession session){
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "redirect:/cart.html";
    }
    
    @RequestMapping(value = "checkout", method = RequestMethod.GET)
    public String checkout(HttpSession session, ModelMap modelMap){
        modelMap.put("title", "Pembelian Barang");
        if(session.getAttribute("username") == null){
            modelMap.put("message", "Anda harus mengisi terlebih dahulu data belanjaan");
            return "account.myaccount";
        }else{
                Orders orders=new Orders();
                orders.setAccount(accountService.find(session.getAttribute("username").toString()));
                orders.setTanggal(new Date());
                Orders newOrders = ordersService.create(orders);
            
                List<Item> cart = (List<Item>) session.getAttribute("cart");
                for(Item item:cart){
                    OrdersDetail ordersDetail=new OrdersDetail();
                    ordersDetail.setId(new OrdersDetailId(newOrders.getIdOrders(), item.getProduct().getIdProduct()));
                    ordersDetail.setPrice(item.getProduct().getPrice());
                    ordersDetail.setQuantity(item.getQuantity());
                    ordersDetailService.create(ordersDetail);
                }
            
                session.removeAttribute("username");
                cart.clear();
                return "cart.thanks";
        }
        
    }
    
    private int isExsist(String id, HttpSession session){
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        for(int i=0; i<cart.size(); i++){
            if(cart.get(i).getProduct().getIdProduct().equals(id)){
                return i;
            }
        }
        return - 1;
    }
    
}
