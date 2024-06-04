package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/home.jsp")
	public ModelAndView home(HttpServletRequest req,HttpSession session) {
		String name ="Adil";
		System.out.println("its :: "+name);
		session.setAttribute("user", name);
		return new ModelAndView("/home.jsp");
	}
	
	
}
