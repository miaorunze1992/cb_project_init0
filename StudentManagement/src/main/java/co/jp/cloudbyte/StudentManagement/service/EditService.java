package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.FormEdit;

public interface EditService {
	public void updateUser(Model model, FormEdit formEdit);
}
