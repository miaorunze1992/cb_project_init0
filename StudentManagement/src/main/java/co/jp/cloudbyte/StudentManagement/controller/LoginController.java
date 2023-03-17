package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;

@Controller
public class LoginController {

	@RequestMapping("userLogin")
	public String userLogin(Model model,LoginForm LoginForm) {
		String usernameDB="admin";
		String passwordDB="admin";
		if(!usernameDB.equals(LoginForm.getUsername())) {
			model.addAttribute("errorMsg","该用户不存在");
			return"index";
		}
		if(!passwordDB.equals(LoginForm.getPassword())) {
			model.addAttribute("errorMsg","用户存在密码错误");
			return"index";
		}

		return"userSearch";
	}

	@RequestMapping("register")
	public String userRegister() {
		return"userRegister";
	}
}
