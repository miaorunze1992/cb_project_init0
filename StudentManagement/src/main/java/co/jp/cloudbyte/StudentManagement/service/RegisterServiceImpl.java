package co.jp.cloudbyte.StudentManagement.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.entity.User;
import co.jp.cloudbyte.StudentManagement.form.FormLogin;
import co.jp.cloudbyte.StudentManagement.form.FormRegister;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	UserInfoMapper userInfoMapper;

	@Override
	public String UserRegister(Model model, FormRegister formRegister) {

		// 一旦在Service层调用DAO层方法，抛出异常，那么证明注册失败
		try {
			userInfoMapper.insertUserInfo(formRegister);
		}catch(Exception e) {
			System.out.println("注册失败");
			model.addAttribute("errorMsg", "注册失败请重试");
			return "user/register";
		}
		// 注册成功
		return "user/search";
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


//	@Override
//	public String Logincheck(Model model, FormLogin forLogin) {
//		//接收用户输入的用户名
//	User userInfo = userInfoMapper.selectUsername(forLogin.getUsername());
//		//判断用户不存在，输出：用户名不存在,请检查，原地跳转
//		if(userInfo==null){
//			model.addAttribute("errorMsg", "用户名不存在,请检查");
//			return "index";
//		}
//		//用户存在，密码不正确输出：密码不正确,请重新输入，原地跳转
//		if(!(userInfo.getPassword().equals(forLogin.getPassword()))) {
//			model.addAttribute("errorMsg", "密码不正确,请重新输入");
//			return "index";
//		}
//		//用户密码正确跳转页面 user/Search跳转,且输出数据
//		//检测是否有数据
//		System.out.println(userInfo);
//		System.out.println(userInfoMapper.selectUserAll());
//		return "user/Search";
//	}
}
