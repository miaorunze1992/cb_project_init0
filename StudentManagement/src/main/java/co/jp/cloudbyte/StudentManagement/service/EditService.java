package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.FormEdit;

public interface EditService {
	public String UserEdit(Model model, FormEdit formEdit);
}
