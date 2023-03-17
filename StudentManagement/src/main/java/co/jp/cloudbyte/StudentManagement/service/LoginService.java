package co.jp.cloudbyte.StudentManagement.service;


import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;


public interface LoginService  {

	public String checkUser(Model model,LoginForm loginForm);

}
