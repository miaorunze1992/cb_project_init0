package co.jp.cloudbyte.StudentManagement.service;

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
import co.jp.cloudbyte.StudentManagement.form.FormSearch;

@SpringBootTest(classes = SearchServiceImpl.class)
@ExtendWith(SpringExtension.class)
public class SearchServiceTest {
	
	@MockBean
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private SearchService searchService;
	
	@BeforeAll
	static void initAll() {
		System.out.println("========SearchService Test Start========");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("==========Junit Case Start==========");
	}
	
	@Test
	public void testSelectUser_正常系(){
		FormSearch formSearch = new FormSearch();
		//等于Model
		Model mockModel = Mockito.mock(Model.class);
		String testResult = searchService.selectUser(mockModel,formSearch);
		Assertions.assertEquals("user/search", testResult);
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("==========Junit Case End==========");
	}
	
	@AfterAll
	static void tearDownAll() {
		System.out.println("========SearchService Test End========");
	}
}
