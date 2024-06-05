package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Customer;

@Controller
@RequestMapping("/customerlogin")
public class CustomerController {
	
	@PostMapping("/balance")
	public ModelAndView balance(@RequestBody Customer c) {
		ModelAndView mv = new ModelAndView("Transaction/balance.html");
		mv.addObject("c",c);
		return mv;
	}
}
