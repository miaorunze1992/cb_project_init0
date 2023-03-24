package co.jp.cloudbyte.StudentManagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.jp.cloudbyte.StudentManagement.entity.User;
import co.jp.cloudbyte.StudentManagement.form.FormRegister;
import co.jp.cloudbyte.StudentManagement.form.FormSearch;

@Mapper
public interface UserInfoMapper {
	User selectUsername(@Param("username")String username);
	int insetRegister(FormRegister formRegister) throws Exception;
	List<User>selectUserAll();
	List<User>selectByCondition(FormSearch formSearch);	
	
}
