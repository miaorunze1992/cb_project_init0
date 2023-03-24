package co.jp.cloudbyte.StudentManagement.service;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.entity.User;
import co.jp.cloudbyte.StudentManagement.form.FormLogin;
import co.jp.cloudbyte.StudentManagement.form.FormRegister;

@SpringBootTest(classes = RegisterServiceImpl.class)
@ExtendWith(SpringExtension.class)
public class RegisterServiceTest {
	
	@MockBean
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private RegisterService registerService;
	
	@BeforeAll
	static void initAll() {
		System.out.println("========RegisterService Test Start========");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("==========Junit Case Start==========");
	}
	
	@Test
	public void testUserRegister正常系_用户注册成功(){
		FormRegister formRegister = new FormRegister();
		//等于Model
		Model mockModel = Mockito.mock(Model.class);
		
		String testResult = registerService.UserRegister(mockModel,formRegister);
		Assertions.assertEquals("user/search", testResult);
	}
	
	@Test
	public void testUserRegister_異常系() throws Exception{
		FormRegister formRegister = new FormRegister();
		//等于Model
		Model mockModel = Mockito.mock(Model.class);
		Mockito.when(userInfoMapper.insertUserInfo(any())).thenThrow((new Exception("注册失败")));
		String testResult = registerService.UserRegister(mockModel,formRegister);
		Assertions.assertEquals("user/register", testResult);
	}

	@AfterEach
	void tearDown() {
		System.out.println("==========Junit Case End==========");
	}
	
	@AfterAll
	static void tearDownAll() {
		System.out.println("========RegisterService Test End========");
	}
}
