package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.FormSearch;
import co.jp.cloudbyte.StudentManagement.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	SearchService searchService;
	
	@GetMapping("/searchByCondition")
	public String searchByCondition(Model model,FormSearch formSearch) {
		
		return searchService.selectUser(model, formSearch);
	}
	
	@RequestMapping("/userEdit")
	public String userInitEdit() {
		System.out.println("username");
		return "user/edit";
	}

}
