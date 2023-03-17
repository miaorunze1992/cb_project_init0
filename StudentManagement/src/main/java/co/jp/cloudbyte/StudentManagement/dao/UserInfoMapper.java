package co.jp.cloudbyte.StudentManagement.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper {

	UserInfoMapper selectUserInfo(@Param("username") String username);
}
