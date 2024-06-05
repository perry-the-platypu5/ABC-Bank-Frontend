package com.example.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Admin;
import com.example.model.Customer;
import com.example.model.Customers;

@Controller
public class MainController {
	RestTemplate rs= new RestTemplate();
	
	@GetMapping("/")
	public String welcome(){
		return "index.html";
	}
	@GetMapping("/admin")
	public String adminLogin(){
		return "admin.html";
	}
	@GetMapping("/customer")
	public String customerLogin(){
		
		return "customer.html";
	}
	
	@PostMapping(value="/customer",consumes = "application/x-www-form-urlencoded")
	public ModelAndView customerLogged(Customer c) {
		Customer cs = rs.postForObject("http://localhost:4242/customer/customerlogin", c, Customer.class);
		ModelAndView mv = new ModelAndView();
		if(cs==null) {
			mv.setViewName("customer.html");
			return mv;
		}
		System.out.println(cs);
		mv.setViewName("customerpage.html");
		mv.addObject("c",cs);
		return mv;
	}
	
	@PostMapping(value="/adminlogin",consumes = "application/x-www-form-urlencoded")
	public String adminLogin(Admin ad) {
	if(ad.getPassword().equals("4747")) {
		return "manage.html";
	}
		return "admin.html";
	}
	
	@GetMapping(value="/getall")
	public ModelAndView getall() {
		ModelAndView mv = new ModelAndView("getall.html");
		Customers cs = rs.getForObject("http://localhost:4242/customer/getall", Customers.class);
		mv.addObject("cs",cs);
		return mv;
	}
	
	@GetMapping("/add")
	public String add() {
		
		return "add.html";
	}
	
	@PostMapping("/add")
	public String addPost(Customer c) {
		rs.postForLocation("http://localhost:4242/customer/add", c);
		return "manage.html";
	}
	
	@GetMapping("/getone")
	public String getone() {
		
		return "getone.html";
	}
	
	@GetMapping("/update")
	public String update() {
		
		return "update.html";
	}
	
	@GetMapping("/delete")
	public String delete() {
		
		return "delete.html";
	}
}
