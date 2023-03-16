package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {
	
	@RequestMapping("userLogin")
	public String UserLogin() {
		return"user/register";
	}
	
	@RequestMapping("register")
	public String RegisterInto() {
		return"user/search";
	}
}
