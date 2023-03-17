package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;
import co.jp.cloudbyte.StudentManagement.service.LoginService;
import co.jp.cloudbyte.StudentManagement.service.LoginServiceImpl;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	@RequestMapping("userLogin")
	public String userLogin(Model model,LoginForm LoginForm) {
//		//创建接口实现LoginServiceImpl类的对象LoginServiceImpl
//		LoginServiceImpl LoginServiceImpl=new LoginServiceImpl();
//		//通过对象.方法调用LoginServiceImpl的checkUser()方法，result接收
//		String result=LoginServiceImpl.checkUser(model, LoginForm);
//		//方法的返回值是页面，可以直接分发
//		return result;
		return loginService.checkUser(model,LoginForm);
	}

	@RequestMapping("register")
	public String userRegister() {
		return"userRegister";
	}
}
