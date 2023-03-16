package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;

@Controller
public class LoginController {
	@RequestMapping("userLogin")
	public String userLogin(LoginForm loginForm) {
		String username = "admin";
		String password = "admin";
		if(!username.equals(loginForm.getUsername())) {
			return "index";
		}
		if(!password.equals(loginForm.getPassword())) {
			return "index";
		}
//		System.out.println("接收的值 start");
//		System.out.println(loginForm.getUsername());
//		System.out.println(loginForm.getPassword());
//		System.out.println("接收的值 end");
		return "user/register";

	}
}
