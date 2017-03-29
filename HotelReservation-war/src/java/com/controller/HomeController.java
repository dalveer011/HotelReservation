/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import hotelreservation.entity.Customers;
import hotelreservation.entity.Addresses;
import com.model.Customer;
import hotelreservation.session.CustomerSessionBeanRemote;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author damil
 */
@Controller
public class HomeController {
    
    @RequestMapping("/home")
    public ModelAndView home(){
    return new ModelAndView("index.jsp");
    }
    
    @RequestMapping("/signup")
    public ModelAndView signup(){
    return new ModelAndView("signup.jsp");
    }
    @RequestMapping("/availability")
    public ModelAndView roomsAvailability(){
    return new ModelAndView("availability.jsp");
    }
    
    @RequestMapping(value = "/register", method=RequestMethod.POST)
    public ModelAndView registeration(@ModelAttribute("register")Customer customer)
    {
        ArrayList al = new ArrayList();
        ModelAndView m = new ModelAndView("index.jsp");
        Customers c = new hotelreservation.entity.Customers();
        c.setCustomerusername(customer.getCustomerusername());
        c.setPassword(customer.getPassword());
        c.setFirstname(customer.getFirstname());
        c.setLastname(customer.getLastname());
        c.setEmail(customer.getEmail());
        c.setPhone(customer.getPhone());
        
        Addresses mailaddress = new Addresses();
        mailaddress.setCity(customer.getMailingAddress().getCity());
        mailaddress.setProvince(customer.getMailingAddress().getProvince());
        mailaddress.setStreet(customer.getMailingAddress().getStreet());
        mailaddress.setCountry(customer.getMailingAddress().getCountry());
        mailaddress.setPostalcode(customer.getMailingAddress().getPostalCode());
        
       
        
        Addresses billaddress = new Addresses();
        
        if(customer.getBillingAddress() != null){
        billaddress.setCity(customer.getBillingAddress().getCity());
        billaddress.setProvince(customer.getBillingAddress().getProvince());
        billaddress.setStreet(customer.getBillingAddress().getStreet());
        billaddress.setCountry(customer.getBillingAddress().getCountry());
        billaddress.setPostalcode(customer.getBillingAddress().getPostalCode());
            al.add(mailaddress);
            al.add(billaddress);
        }else{
        al.add(mailaddress);
        }
        try {
            Context ctx = new InitialContext();
            CustomerSessionBeanRemote cusRemote = (CustomerSessionBeanRemote)ctx.lookup(CustomerSessionBeanRemote.class.getName());
            
            
            
           if( cusRemote.registerCustomer(c, al))
           {
               System.out.println("added successfully");
               m.addObject("message", "Sign up process has been completed successfully");
           }
           else
           {
               m.addObject("message", "User already exist please try another username");
           }
            
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        }
        
      return m;
    
    }
}
