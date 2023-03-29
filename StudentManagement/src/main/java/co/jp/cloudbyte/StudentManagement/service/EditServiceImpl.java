package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.form.FormEdit;

@Service
public class EditServiceImpl implements EditService{
	@Autowired
	UserInfoMapper userInfoMapper;

	@Override
	public String UserEdit(Model model, FormEdit formEdit) {
		
		userInfoMapper.upDateUser(formEdit);
		model.addAttribute("users", userInfoMapper.selectUserAll());
		return "user/search";
	}

	
}
