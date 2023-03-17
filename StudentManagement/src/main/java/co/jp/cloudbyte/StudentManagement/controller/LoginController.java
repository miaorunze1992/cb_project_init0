package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;
import co.jp.cloudbyte.StudentManagement.service.LoginService;


@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	@RequestMapping("userLogin")
	public String userLogin(Model model,LoginForm loginForm) {

//		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
//		String result = loginServiceImpl.checkUser(model, loginForm);
//		return result;

	return loginService.checkUser(model,loginForm);

	}

	@RequestMapping("register")
	public String userRegister() {
		return "userRegister";
	}
}
