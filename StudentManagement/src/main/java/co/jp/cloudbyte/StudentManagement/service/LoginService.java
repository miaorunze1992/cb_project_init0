package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.FormLogin;

public interface LoginService {
	public String Logincheck(Model model, FormLogin forLogin);
}
