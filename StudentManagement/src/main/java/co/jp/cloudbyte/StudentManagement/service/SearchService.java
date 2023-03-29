package co.jp.cloudbyte.StudentManagement.service;

import java.util.Map;

import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.FormSearch;

public interface SearchService {
	
	public String searchByCondition(Model model, FormSearch formSearch);
	
	public String editUser(Model model,String username);
	
	public String deleteUser(Model model,String username);
	
	public void deleteUserAll(Model model, Map<String, String> map);
	
	public void searchAll(Model model);
	
}
