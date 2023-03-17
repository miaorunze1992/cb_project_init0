package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.FormLogin;
import co.jp.cloudbyte.StudentManagement.service.LoginService;

@Controller

public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping("userLogin")
	public String UserLogin(Model model,FormLogin formLogin) {
		return loginService.Logincheck(model, formLogin);
	}

	@RequestMapping("register")
	public String RegisterInto() {
		return"user/register";
	}
}