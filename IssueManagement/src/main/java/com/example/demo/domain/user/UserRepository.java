package com.example.demo.domain.user;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {
	
	@Insert("insert into users (username, password, authority) values (#{username}, #{password}, #{authority})")
	void create(@Param("username")String username, @Param("password")String password, @Param("authority")String authority);

	@Select("select * from users")
	List<UserEntity> findAll();

}
