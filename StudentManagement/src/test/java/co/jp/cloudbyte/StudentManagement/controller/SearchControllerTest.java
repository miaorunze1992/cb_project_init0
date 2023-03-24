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

import co.jp.cloudbyte.StudentManagement.form.FormSearch;
import co.jp.cloudbyte.StudentManagement.service.SearchService;

@SpringBootTest(classes = SearchController.class)
@ExtendWith(SpringExtension.class)
public class SearchControllerTest {
	
	@MockBean
	private SearchService searchService;
	
	@Autowired
	private SearchController searchController;
	
	@BeforeAll
	static void initAll() {
		System.out.println("========SearchController Test Start========");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("==========Junit Case Start==========");
	}
		
	@Test
	public void testSearchChange_正常系(){
		//接收searchInto的返回值
		FormSearch formSearch = new FormSearch();
		//默认得到的结果为user/search
		Mockito.when(searchService.selectUser(null, formSearch)).thenReturn("user/search");
		String testResult = searchController.searchByCondition(null, formSearch);
		Assertions.assertEquals("user/search", testResult);
	}
		
	@AfterEach
	void tearDown() {
		System.out.println("==========Junit Case End==========");
	}
	
	@AfterAll
	static void tearDownAll() {
		System.out.println("========SearchController Test End========");
	}
}
