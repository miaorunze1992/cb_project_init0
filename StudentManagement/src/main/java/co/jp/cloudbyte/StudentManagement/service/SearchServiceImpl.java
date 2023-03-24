package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.form.FormSearch;
@Service
public class SearchServiceImpl implements SearchService{
	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Override
	public String selectUser(Model model,FormSearch formSearch) {
		
		model.addAttribute("users", userInfoMapper.selectByCondition(formSearch));
		return "user/search";

	}

	@Override
	public String upDateUser(Model model,@RequestParam("username")String username) {
		
		System.out.println(username);
		
		return "user/edit";
	}

}

