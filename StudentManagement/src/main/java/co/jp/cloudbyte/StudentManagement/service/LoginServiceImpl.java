package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.FormLogin;

@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public String Logincheck(Model model, FormLogin forLogin) {
		//假数据
		String userDB="lin";
		String pwdDB="123";
		// TODO 自動生成されたメソッド・スタブ
		//判断用户是否存在，不存在时候输出：用户名不存在,请检查，原地跳转
		if(!userDB.equals(forLogin.getUsername())){
			model.addAttribute("errorMsg", "用户名不存在,请检查");
			return "index";
		}
		//用户存在，密码是正确，不正确时输出：密码不正确,请重新输入，原地跳转
		if(!pwdDB.equals(forLogin.getPassword())) {
			model.addAttribute("errorMsg", "密码不正确,请重新输入");
			return "index";
		}
		//用户密码正确跳转页面 user/Search跳转,且输出数据
		return "user/Search";
	}

}
