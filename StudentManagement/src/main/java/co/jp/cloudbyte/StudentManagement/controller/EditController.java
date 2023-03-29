package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import co.jp.cloudbyte.StudentManagement.form.FormEdit;
import co.jp.cloudbyte.StudentManagement.service.EditService;

@Controller
public class EditController {
	@Autowired
	EditService editService;
	
	//数据更新 变更按键
	@PostMapping("userEdit")
	public String UserRegister(Model model,FormEdit formEdit) {
		
		return editService.UserEdit(model, formEdit);
	}
	
}
