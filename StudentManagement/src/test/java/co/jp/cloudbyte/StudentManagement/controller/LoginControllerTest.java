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
import co.jp.cloudbyte.StudentManagement.service.LoginService;

@SpringBootTest(classes = LoginController.class)
@ExtendWith(SpringExtension.class)
public class LoginControllerTest {
	
	@MockBean
	private LoginService loginService;
	
	@Autowired
	private LoginController loginController;
	
	@BeforeAll
	static void initAll() {
		System.out.println("========LoginController Test Start========");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("==========Junit Case Start==========");
	}
	
	@Test
	public void testRegisterInto_正常系(){
		//接收RegisterInto的返回值
		String tsetResult = loginController.RegisterInto();
		Assertions.assertEquals("user/register", tsetResult);
	}
	
	@Test
	public void testUserLogin_正常系(){
		//接收RegisterInto的返回值
		FormLogin formLogin = new FormLogin();
		//默认得到的结果为index
		//
		Mockito.when(loginService.Logincheck(null, formLogin)).thenReturn("index");
		String tsetResult = loginController.UserLogin(null,formLogin);
		Assertions.assertEquals("index", tsetResult);
	}
	
	@Test
	public void testUserLogin_異常系(){
		FormLogin formLogin = new FormLogin();
		String tsetResult = loginController.UserLogin(null,formLogin);
		Assertions.assertEquals(null, tsetResult);
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("==========Junit Case End==========");
	}
	
	@AfterAll
	static void tearDownAll() {
		System.out.println("========LoginController Test End========");
	}
}
