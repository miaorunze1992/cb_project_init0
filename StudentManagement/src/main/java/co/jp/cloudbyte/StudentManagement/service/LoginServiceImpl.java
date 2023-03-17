package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.entity.UserInfo;
import co.jp.cloudbyte.StudentManagement.form.LoginForm;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	UserInfoMapper userInfoMapper;
	@Override
	public String checkUser(Model model,LoginForm loginForm) {
	   //从数据库取值，通过dao层
		UserInfo userInfo=userInfoMapper.selectUserInfo(loginForm.getUsername());
		if(userInfo==null) {
			model.addAttribute("errorMsg","该用户不存在");
			return"index";
		}else {
			String passwordDB=userInfo.getPassword();
			if(!passwordDB.equals(loginForm.getPassword())) {
				model.addAttribute("errorMsg","用户存在 密码错误");
				return"index";
			}

		}
//	//假数据
//		String usernameDB="admin";
//		String passwordDB="admin";
		//业务逻辑
		//查询没有此用户，原地跳转，报错。
//		if(!usernameDB.equals(LoginForm.getUsername())) {
//			model.addAttribute("errorMsg","该用户不存在");
//			return"index";
//		}
//		//有此用户，检查密码，并且报错
//		if(!passwordDB.equals(LoginForm.getPassword())) {
//			model.addAttribute("errorMsg","用户存在 密码错误");
//			return"index";
//		}
		//用户密码正确，跳转用户一栏
		return"userSearch";
	}

}
