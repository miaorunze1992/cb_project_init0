package co.jp.cloudbyte.StudentManagement.controller;

import java.util.concurrent.Flow.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;
import co.jp.cloudbyte.StudentManagement.service.LoginService;
import co.jp.cloudbyte.StudentManagement.service.LoginServiceImpl;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@RequestMapping("userLogin")
	public String userLogin(Model model,LoginForm loginForm) {

	//	LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
	//	String result = loginServiceImpl.checkUser(model, loginForm);
		return loginService.checkUser(model, loginForm);
	}

		public String UserRegister() {
			return null;
		}
}

//		String usernameDB = "admin";
//		String passwordDB = "admin";
//
//		if (!usernameDB.equals(loginForm.getUsername())) {
//			model.addAttribute("errorMsg","该用户不存在");
//			return "index";
//		}
//
//		if (!passwordDB.equals(loginForm.getPassword())) {
//			model.addAttribute("errorMsg","用户存在,但是密码错误");
//			return "index";
//		}
//		System.out.println("登录成功");
//		return "user/search";

//	@RequestMapping("register")
//	public String useRegister() {
//	return"user/register";



