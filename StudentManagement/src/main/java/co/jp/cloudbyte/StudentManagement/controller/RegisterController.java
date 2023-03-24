package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.FormRegister;
import co.jp.cloudbyte.StudentManagement.service.RegisterService;

@Controller
public class RegisterController {
	@Autowired
	RegisterService registerService;

	@RequestMapping("userRegister")
	public String UserRegister(Model model,FormRegister formRegister) {
		
		System.out.println(formRegister);
		
		return registerService.UserRegister(model, formRegister);
	}


}