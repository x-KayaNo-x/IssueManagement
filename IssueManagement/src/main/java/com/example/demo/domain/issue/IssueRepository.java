package com.example.demo.domain.issue;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IssueRepository {

	@Select("select * from issues")
	List<IssueEntity> findAll();

	@Select("select * from issues where id = #{id}")
	IssueEntity findById(int id);

	@Insert("insert into issues (summary, description, userId, priorityId) "
			+ "values (#{summary}, #{desctiption}, 1, 2)")
	void create(@Param("summary")String summary, @Param("desctiption")String description);
}
