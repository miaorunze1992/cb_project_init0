package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.entity.User;
import co.jp.cloudbyte.StudentManagement.form.FormLogin;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	UserInfoMapper userInfoMapper;
	@Override
	public String Logincheck(Model model, FormLogin forLogin) {
		//接收用户输入的用户名
	User userInfo = userInfoMapper.selectUsername(forLogin.getUsername());
		//判断用户不存在，输出：用户名不存在,请检查，原地跳转
		if(userInfo==null){
			model.addAttribute("errorMsg", "用户名不存在,请检查");
			return "index";
		}
		//用户存在，密码不正确输出：密码不正确,请重新输入，原地跳转
		if(!(userInfo.getPassword().equals(forLogin.getPassword()))) {
			model.addAttribute("errorMsg", "密码不正确,请重新输入");
			return "index";
		}
		//用户密码正确跳转页面 user/Search跳转,且输出数据
			model.addAttribute("users", userInfoMapper.selectUserAll());
		return "user/search";
	}
}
