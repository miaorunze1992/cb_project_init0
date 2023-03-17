package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;

public class LoginServiceImpl implements LoginService{

	@Override
	public String checkUser(Model model,LoginForm loginForm) {

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


	}


