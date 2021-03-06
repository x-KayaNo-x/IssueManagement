package com.example.demo.domain.auth;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {

	@Select("select * from users where username = #{usernmae}")
	Optional<User> findByUsername(String username);
	
	
	@Insert("insert into users (username, password, authority) values (#{username}, #{password}, #{authority})")
	void create(@Param("username")String username, @Param("password")String password, @Param("authority")String authority);

	@Select("select * from users order by authority")
	List<User> findAll();

	@Delete("delete from users where username = #{username}")
	void delete(String username);

	
}

