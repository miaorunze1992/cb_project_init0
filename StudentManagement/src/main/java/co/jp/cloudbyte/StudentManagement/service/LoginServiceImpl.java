package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;

public class LoginServiceImpl implements LoginService {

	@Override
	public String checkUser(Model model,LoginForm loginForm) {
		String username = "admin";
		String password = "admin";
		if(!username.equals(loginForm.getUsername())) {
			model.addAttribute("errorMsg","用户名错误");
			return "index";
		}
		if(!password.equals(loginForm.getPassword())) {
			model.addAttribute("errorMsg","用户名正确，但密码错误");
			return "index";
		}
		return "userSearch";


	}

}
