package co.jp.cloudbyte.StudentManagement.service;

import static org.mockito.ArgumentMatchers.*;

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
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.entity.User;
import co.jp.cloudbyte.StudentManagement.form.FormLogin;

@SpringBootTest(classes = LoginServiceImpl.class)
@ExtendWith(SpringExtension.class)
public class LoginServiceTest {
	
	@MockBean
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private LoginService loginService;
	
	@BeforeAll
	static void initAll() {
		System.out.println("========LoginController Test Start========");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("==========Junit Case Start==========");
	}
	
	@Test
	public void testLogincheck_正常系_用户不存在(){
		FormLogin formLogin = new FormLogin();
		//等于Model
		Model mockModel = Mockito.mock(Model.class);
		//当作数据库接收到到值为null
		Mockito.when(userInfoMapper.selectUsername(any())).thenReturn(null);
		
		String tsetResult = loginService.Logincheck(mockModel,formLogin);
		//断言  用户不存在 if语句（userInfo==null）
		Assertions.assertEquals("index", tsetResult);
	}
	
	@Test
	public void testLogincheck_正常系_密码正确(){
		FormLogin formLogin = new FormLogin();
		formLogin.setPassword("888");
		//等于Model
		Model mockModel = Mockito.mock(Model.class);
		User user = new User();
		user.setPassword("888");
		//当作数据库接收到到值为null
		Mockito.when(userInfoMapper.selectUsername(any())).thenReturn(user);
		
		String tsetResult = loginService.Logincheck(mockModel,formLogin);
		//断言  用户不存在 if语句（userInfo==null）
		Assertions.assertEquals("user/Search", tsetResult);
	}
	
	@Test
	public void testLogincheck_正常系_密码不正确(){
		FormLogin formLogin = new FormLogin();
		formLogin.setPassword("777");
		//等于Model
		Model mockModel = Mockito.mock(Model.class);
		User user = new User();
		user.setPassword("888");
		//当作数据库接收到到值为null
		Mockito.when(userInfoMapper.selectUsername(any())).thenReturn(user);
		
		String tsetResult = loginService.Logincheck(mockModel,formLogin);
		//断言  用户不存在 if语句（userInfo==null）
		Assertions.assertEquals("index", tsetResult);
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
