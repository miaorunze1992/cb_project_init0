package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.jp.cloudbyte.StudentManagement.form.FormSearch;
import co.jp.cloudbyte.StudentManagement.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	SearchService searchService;
	
	//页面显示
	@GetMapping("/searchByCondition")
	public String searchByCondition(Model model,FormSearch formSearch) {
		
		return searchService.selectUser(model, formSearch);
	}
	//变更跳转
	@RequestMapping("/editUser")
	public String EditUser(Model model,@RequestParam("username")String username) {
		
		return searchService.EditUser(model, username);
	}
	//删除跳转
	@RequestMapping("/deleteUser")
	public String DeleteUser(Model model,@RequestParam("username")String username) {
		
		return searchService.DeleteUser(model, username);
	}
	
	//新规登入跳转
	@RequestMapping("registerTo")
	public String RegisterTO() {
		return"user/register";
	}
	//ajax 局部刷新
	@PostMapping("/deleteChecked")
    public String list(Model model) {
        System.out.println("ist");
        return "user/search";
    }
	
	//ajax页面全部刷新
//		@RequestMapping("userSearch")
//		public String userSearch(Model model) {
//			
//			return searchService.userSearchAll(model);
//		}
	//function 方法
//	@RequestMapping("deleteChecked")
//	public String deleteChecked(Model model, @RequestParam("nameArr") String nameArr) {
//		
//		return searchService.DeleteChecked(model, nameArr);
//	}
	
}
