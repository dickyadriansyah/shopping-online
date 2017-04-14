/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.controlleradmin;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dicky-java
 */
@Controller
@RequestMapping(value = "/main")
public class MainController {
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "redirect:/main/login.html";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, 
            @RequestParam(value = "logout", required = false) String logout, ModelMap modelMap){
        
        if(error!=null){
            modelMap.addAttribute("msg", "Invalid Username and Password");
        }
        
        if(logout!=null){
            modelMap.addAttribute("msg", "You've been logged out successfully");
        }
        return "admin.main.login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        return "admin.main.login";
    }
    
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(ModelMap modelMap){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)){
            UserDetails userDetails=(UserDetails) auth.getPrincipal();
            modelMap.addAttribute("username", userDetails.getUsername());
        }
        return "admin.main.403";
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(){
        return "admin.main.welcome";
        
    }
    
}
