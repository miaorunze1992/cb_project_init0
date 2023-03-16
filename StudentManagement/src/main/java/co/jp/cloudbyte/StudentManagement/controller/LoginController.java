package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;

@Controller
public class LoginController {

	@RequestMapping("user11")
	public String userLogin(Model model,LoginForm loginForm) {
		String username = "admin";
		String password = "admin";

		if (!username.equals(loginForm.getUsername())) {
			return "index";
		}

		if (!username.equals(loginForm.getPassword())) {
			return "index";
		}

		return "user/search";
	}
}
