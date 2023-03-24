package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.form.FormRegister;

@Service
public class RegisterServiceImpl implements RegisterService{
	@Autowired
	UserInfoMapper userInfoMapper;

	@Override
	public String UserRegister(Model model, FormRegister formRegister) {
	
		try{
			userInfoMapper.insetRegister(formRegister);
		}catch (Exception e) {
			//注册失败 原地跳转
			//System.out.println("注册失败");
			model.addAttribute("errorMsg", "注册失败,请检查注册信息！");
			return "user/register";
		}
		//注册成功 跳转页面
			model.addAttribute("users",userInfoMapper.selectUserAll());
		return "user/search";
	}
}
