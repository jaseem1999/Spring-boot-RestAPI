package com.demo.h2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.h2.dao.UserDAO;
import com.demo.h2.model.dto.UserDTO;

@Controller
public class RegisterController {
	
	@Autowired
	private UserDAO userdao;
	
	@RequestMapping("/")
	public String register() {
		return "login.jsp";
	}
	
	@RequestMapping(value ="/signin", method = RequestMethod.POST)
	public String signin(UserDTO user) {
		userdao.save(user);
		return "login.jsp";
	}
	
	@RequestMapping("/getUsers.jsp")
	public String getUserTemplete() {
		return "getUsers.jsp";
	}
	
	@RequestMapping("/getuser")
	public ModelAndView getUserBasedId(@RequestParam int id) {
		UserDTO user=userdao.findById(id).orElse(null);
		System.out.println(user);
		return new ModelAndView("/getUsers.jsp","userDto",user);
	}
	
	@RequestMapping("/updateUser")
	public ModelAndView updateUserBasedId(UserDTO user) {
		userdao.save(user);
		UserDTO userUpdated = userdao.findById(user.getId()).orElse(null);
		return new ModelAndView("/getUsers.jsp","userDto",userUpdated);
	}
	
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUserBasedId(int id) {
		userdao.deleteById(id);
		UserDTO userUpdated = userdao.findById(id).orElse(null);
		return new ModelAndView("/getUsers.jsp","userDto",userUpdated);
	}
	
	@RequestMapping("/userLogin")
	public ModelAndView login(@RequestParam String email,@RequestParam String pass) {
		List<UserDTO> userlist=userdao.login(email, pass);
		UserDTO user = null;
		if(!userlist.isEmpty()) {
			user = userlist.get(0);
			return new ModelAndView("home.jsp","user", user);
		}else {
			return new ModelAndView("login.jsp","loginFialed","Login Failed");
		}
	}
}
