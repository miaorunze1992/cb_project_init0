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
	public String EditUser(Model model,@RequestParam("username")String username) {
		
		model.addAttribute("user", userInfoMapper.selectUsername(username));
		
		return "user/edit";
	}

	@Override
	public String DeleteUser(Model model, String username) {
		
		userInfoMapper.DeleteUser(username);
		model.addAttribute("users", userInfoMapper.selectUserAll());
		return "user/search";
	}

//	@Override
//	public String DeleteChecked(Model model, String nameArr) {
//	
//		String[] nameArrArray = nameArr.split(",");
//
//		for(int i=0;i<nameArrArray.length;i++) {
//			userInfoMapper.DeleteUser(nameArrArray[i]);
//		}
//		return "user/search";
//	}
//	@Override
//	public String userSearchAll(Model model) {
//		// TODO 自動生成されたメソッド・スタブ
//		model.addAttribute("users", userInfoMapper.selectUserAll());
//		return "user/search";
//	}

}

