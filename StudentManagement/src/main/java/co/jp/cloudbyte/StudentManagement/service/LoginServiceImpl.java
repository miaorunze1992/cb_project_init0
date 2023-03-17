package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;

public class LoginServiceImpl implements LoginService{
	@Override
	public String checkUser(Model model,LoginForm LoginForm) {
		String usernameDB="admin";
		String passwordDB="admin";
		if(!usernameDB.equals(LoginForm.getUsername())) {
			model.addAttribute("errorMsg","该用户不存在");
			return"index";
		}
		if(!passwordDB.equals(LoginForm.getPassword())) {
			model.addAttribute("errorMsg","用户存在 密码错误");
			return"index";
		}
		return"userSearch";
	}

}
