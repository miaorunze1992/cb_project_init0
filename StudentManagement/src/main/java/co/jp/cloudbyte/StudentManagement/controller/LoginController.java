package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;

@Controller
public class LoginController {

	@RequestMapping("userLogin")
	public String userLogin(Model model,LoginForm loginForm) {


		String usernameDB = "admin";
		String passwordDB = "123";

		if(!usernameDB.equals(loginForm.getUsername())) {
			model.addAttribute("errorMsg","该用户不存在");
			return "index";
		}

		if(!passwordDB.equals(loginForm.getPassword())) {
			model.addAttribute("errorMsg","该用户存在,密码不正确");
			return "index";
		}

		return "userSearch";
	}

	@RequestMapping("register")
	public String userRegister() {
		return "userRegister";
	}
}
