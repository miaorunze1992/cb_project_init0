package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;
import co.jp.cloudbyte.StudentManagement.service.LoginServiceImpl;

@Controller
public class LoginController {

	@RequestMapping("userLogin")
	public String userLogin(Model model,LoginForm LoginForm) {
		LoginServiceImpl LoginServiceImpl=new LoginServiceImpl();
		String result=LoginServiceImpl.checkUser(model, LoginForm);
		return result;
	}

	@RequestMapping("register")
	public String userRegister() {
		return"userRegister";
	}
}
