package com.project.SignupLoginFeatureSpringBoot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.SignupLoginFeatureSpringBoot.entity.UserEntity;
import com.project.SignupLoginFeatureSpringBoot.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/")
	public String getSigninPage() {
		return "Signin";
	}
	
	@GetMapping("get_home_page")
	public String getHomePage(@RequestParam String username,Model model){
		UserEntity user = loginService.getTheUser(username);
		System.out.println(user);
		model.addAttribute("user",user);
		return "home";
	}
	
	@PostMapping("Signin")
	public String authenticateUser(@ModelAttribute("user") UserEntity user,Model model) {
		System.out.println("Controller   = "+user);
		boolean result = loginService.doAuthenticate(user);
		System.out.println("Result = "+result);
		if(result) {
			System.out.println("Result = "+result);
			model.addAttribute("user",user);
			return "home";
		}
		else {
		return "WrongCreden";
		}
	}	
	
	@GetMapping("show_profile")
	public String showProfile(@RequestParam String username,Model model){		
		UserEntity user = loginService.getTheUser(username);
		model.addAttribute("user",user);
		return "profile";			
	}
	
	@GetMapping("logout")
	public String logout() {
		return "redirect:/";
	}
	
	@GetMapping("get_update_form")
	public String getUpdateProfileForm(@RequestParam String username,Model model){
		UserEntity user = loginService.getTheUser(username);
		model.addAttribute("user",user);
		return "update";
	}
	
	@PostMapping("update_profile")
	public String updateProfile(UserEntity user,@RequestParam String username,Model model) {
		//System.out.println("Controller   = "+user);
		user.setUserName(username);
		UserEntity userFromDB = loginService.updateTheUser(user);
		model.addAttribute("user", userFromDB);
		return "home";
	}
	
	@GetMapping("get_register_form")
	public String getRegisterProfileForm(Model model){
		model.addAttribute("user",new UserEntity());
		return "Signup";
	}
	
	@PostMapping("Signup")
	public String registerTheUser(UserEntity user) {
		//System.out.println("Controller   = "+user);
		loginService.saveTheUser(user);
		return "RegSuc";
	}


}
