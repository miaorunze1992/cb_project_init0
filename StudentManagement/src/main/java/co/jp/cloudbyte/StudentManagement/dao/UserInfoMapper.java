package co.jp.cloudbyte.StudentManagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.jp.cloudbyte.StudentManagement.entity.User;

@Mapper
public interface UserInfoMapper {
	User selectUsername(@Param("username")String username);
	List<User>selectUserAll();
}
