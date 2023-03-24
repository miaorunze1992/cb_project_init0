package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import co.jp.cloudbyte.StudentManagement.form.FormRegister;
import co.jp.cloudbyte.StudentManagement.service.RegisterService;

@Controller
public class RegisterController {
	@Autowired
	RegisterService registerService;
	
	@PostMapping("userRegister")
	public String UserRegister(Model model,FormRegister formRegister) {
		
		return registerService.UserRegister(model, formRegister);
	}
}
