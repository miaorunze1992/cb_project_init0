package co.jp.cloudbyte.StudentManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.entity.User;
import co.jp.cloudbyte.StudentManagement.form.FormEdit;
import co.jp.cloudbyte.StudentManagement.form.FormLogin;

@Service
public class EditServiceImpl implements EditService{
	@Autowired
	UserInfoMapper userInfoMapper;

	@Override
	public void updateUser(Model model, FormEdit formEdit) {
		userInfoMapper.updateUser(formEdit);
		List<User> list = userInfoMapper.selectUserAll();
		model.addAttribute("allData", list);
	}


}
