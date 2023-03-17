package co.jp.cloudbyte.StudentManagement.entity;

import lombok.Data;

@Data
public class UserInfo {
	private String username;
	private String password;
	private String gender;
	private String address;
	private String country;
	private String comment;

}
