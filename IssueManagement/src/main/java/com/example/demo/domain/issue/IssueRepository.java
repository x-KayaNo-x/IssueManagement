package com.example.demo.domain.issue;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IssueRepository {

	@Select("select issues.id, summary, description, priority "
			+ "from issues left join priority on priorityId = priority.id")
	List<IssueEntity> findAll();

	@Select("select issues.id, summary, description, priority from issues "
			+"left join priority on priorityId = priority.id where issues.id = #{id}")
	IssueEntity findById(int id);

	@Insert("insert into issues (summary, description, userId, priorityId) "
			+ "values (#{summary}, #{desctiption}, 1, #{priorityId})")
	void create(@Param("summary")String summary, @Param("desctiption")String description,
			@Param("priorityId") int priorityId);
}
