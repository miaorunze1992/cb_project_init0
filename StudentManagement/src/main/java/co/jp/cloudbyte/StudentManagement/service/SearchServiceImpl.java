package co.jp.cloudbyte.StudentManagement.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.entity.User;
import co.jp.cloudbyte.StudentManagement.form.FormSearch;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	UserInfoMapper userInfoMapper;

	@Override
	public String searchByCondition(Model model, FormSearch formSearch) {
		
		List<User> usersData = userInfoMapper.selectUserByCondition(formSearch);
		
		model.addAttribute("allData", usersData);
		
		return "user/search";
	}

	@Override
	public String editUser(Model model, String username) {
		User user = userInfoMapper.selectUsername(username);
		model.addAttribute("User", user);
		return "user/edit";
	}

	@Override
	public String deleteUser(Model model,String username) {
		userInfoMapper.deleteUser(username);
		List<User> usersData = userInfoMapper.selectUserAll();
		model.addAttribute("allData", usersData);
		return "user/search";
	}
	
	

}
