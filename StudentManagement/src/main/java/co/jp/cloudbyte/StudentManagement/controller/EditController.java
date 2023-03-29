package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.jp.cloudbyte.StudentManagement.form.FormEdit;
import co.jp.cloudbyte.StudentManagement.form.FormSearch;
import co.jp.cloudbyte.StudentManagement.service.EditService;
import co.jp.cloudbyte.StudentManagement.service.SearchService;

@Controller
public class EditController {
	
	@Autowired
	EditService editService;
	
	@RequestMapping("/userEdit")
	public String edit(Model model, FormEdit formEdit) {
		editService.updateUser(model, formEdit);
		return "user/Search";
	}
	
//	@Autowired
//	SearchService searchService;
//
//	@RequestMapping("/searchByCondition")
//	public String searchByCondition(Model model,FormSearch formSearch) {
//		return searchService.searchByCondition(model, formSearch);
//	}
//	
//	
//	@RequestMapping("/editUser")
//	public String editUser(Model model,@RequestParam(value="username") String username) {
//		return searchService.editUser(model, username);
//	}
//	
//	@RequestMapping("/deleteUser")
//	public String deleteUser(Model model,@RequestParam(value="username") String username) {
//		return searchService.deleteUser(model,username);
//	}
//	
//	@RequestMapping("/registerFromSearch")
//	public String registerFromSearch() {
//		return "user/register";
//	}


}