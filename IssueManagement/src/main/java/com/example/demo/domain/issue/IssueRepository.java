package com.example.demo.domain.issue;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IssueRepository {

	@Select("select * from issues")
	List<IssueEntity> findAll();

	@Select("select * from issues where id = #{id}")
	IssueEntity findById(int id);
}
