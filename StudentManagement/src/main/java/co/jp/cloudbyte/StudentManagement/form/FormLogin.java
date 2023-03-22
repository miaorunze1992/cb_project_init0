package co.jp.cloudbyte.StudentManagement.form;

import lombok.Data;

@Data
public class FormLogin {
	private String username;
	private String password;
	private String remember;
}
