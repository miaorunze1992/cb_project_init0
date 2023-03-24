package co.jp.cloudbyte.StudentManagement.service;

import java.util.ArrayList;
import java.util.List;

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
		//检测是否有数据
//		System.out.println(userInfo);
//		System.out.println(userInfoMapper.selectUserAll());
		
		// 成功登录跳转到一览画面之前，要给一览画面整数据 
		// 往哪里送数据给一览画面？ model
		// model里面放什么数据？ 数据库里面userinfo这张表的所有数据
		// 谁来查询数据？ DAO层
		// 1.接口  2.接口的实现xml
		List<User> list = userInfoMapper.selectUserAll();
		// 把数据放入到model里面
		model.addAttribute("allData", list);
		// 这次跳转就是带着数据跳转的，那数据在哪儿？
		return "user/Search";
	}
}
