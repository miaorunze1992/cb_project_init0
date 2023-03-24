package co.jp.cloudbyte.StudentManagement.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.jp.cloudbyte.StudentManagement.form.FormLogin;
import co.jp.cloudbyte.StudentManagement.form.FormRegister;
import co.jp.cloudbyte.StudentManagement.service.LoginService;
import co.jp.cloudbyte.StudentManagement.service.RegisterService;

@SpringBootTest(classes = RegisterController.class)
@ExtendWith(SpringExtension.class)
public class RegisterControllerTest {
	
	@MockBean
	private RegisterService registerService;
	
	@Autowired
	private RegisterController registerController;
	
	@BeforeAll
	static void initAll() {
		System.out.println("========RegisterController Test Start========");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("==========Junit Case Start==========");
	}
	

	
	@Test
	public void testUserRegister_正常系(){
		//接收RegisterInto的返回值
		FormRegister formRegister = new FormRegister();
		//默认得到的结果为 user/register
		Mockito.when(registerService.UserRegister(null, formRegister)).thenReturn("user/register");
		String tsetResult = registerController.UserRegister(null,formRegister);
		Assertions.assertEquals("user/register", tsetResult);
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("==========Junit Case End==========");
	}
	
	@AfterAll
	static void tearDownAll() {
		System.out.println("========RegisterController Test End========");
	}
}
