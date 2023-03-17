package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.entity.UserInfo;
import co.jp.cloudbyte.StudentManagement.form.LoginForm;

@Service
public class LoginServiceImpl implements LoginService {

@Autowired
UserInfoMapper userInfoMapper;

	@Override
	public String checkUser(Model model,LoginForm loginForm) {

	UserInfo userInfo = userInfoMapper.selectUserInfo(loginForm.getUsername());

	if(userInfo == null) {
		model.addAttribute("errorMsg","用户名错误");
		return "index";
	}
	String passwordDB = userInfo.getPassword();
	if(!passwordDB.equals(loginForm.getPassword())) {
		model.addAttribute("errorMsg","用户名正确，但密码错误");
		return "index";
	}

	return "userSearch";


	}

}
