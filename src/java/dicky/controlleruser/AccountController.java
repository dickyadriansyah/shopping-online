/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.controlleruser;

import dicky.entities.Account;
import dicky.services.AccountService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dicky-java
 */
@Controller
@RequestMapping("account")
public class AccountController {
    
    @Autowired
    private AccountService accountService;
    
    @RequestMapping(value = "myaccount", method = RequestMethod.GET)
    public String myaccount(ModelMap modelMap){
        modelMap.put("title", "My Account");
        return "account.myaccount";
    }
    
    @RequestMapping(value = "myaccount", method = RequestMethod.POST)
    public String myaccount(HttpServletRequest request, HttpSession session, ModelMap modelMap){
        modelMap.put("title", "My Account");
        Account account=this.accountService.login(
                request.getParameter("username"), 
                request.getParameter("password"));
        if(account != null){
            session.setAttribute("username", request.getParameter("username"));
            modelMap.put("fullname", account.getFullname());
            return "account.welcome";
        }else{
            modelMap.put("error", "Account's Invalid!");
            return "account.myaccount";
        }
        
    }
    
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("username");
        return "redirect:/account/myaccount.html";
    }
    
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(ModelMap modelMap){
        modelMap.put("title", "Registration");
        modelMap.put("account", new Account());
        return "account.register";
    }
    
    
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@ModelAttribute("account") Account account, ModelMap modelMap){
        modelMap.put("title", "Registration");
        try {
            accountService.create(account);
            return "account.myaccount";
        } catch (Exception e) {
            modelMap.put("error", "Data Account Sudah Tersedia !");
            return "account.register";
        }
        
    }
    
}
