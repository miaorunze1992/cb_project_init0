package co.jp.cloudbyte.StudentManagement.form;

import lombok.Data;

@Data
public class LoginForm {
	private String username;
	private String password;
	private Integer gender;
	private String address;
	private Integer country;
	private String comment;
}
