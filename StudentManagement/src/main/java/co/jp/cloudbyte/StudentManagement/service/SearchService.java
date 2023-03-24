package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import co.jp.cloudbyte.StudentManagement.form.FormSearch;

public interface SearchService {
	
	public String selectUser(Model model,FormSearch formSearch);
	
	public String upDateUser(Model model,@RequestParam("username")String username);
}
