package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.FormRegister;

public interface RegisterService {
	public String UserRegister(Model model,FormRegister formRegister);
}
