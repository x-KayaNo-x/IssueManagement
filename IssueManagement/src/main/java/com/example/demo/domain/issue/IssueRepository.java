package com.example.demo.domain.issue;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IssueRepository {

	@Select("select issues.id, summary, description, priority "
			+ "from issues left join priority on priorityId = priority.id "
			+ "where username = #{nsername} "
			+ "order by priorityId")
	List<IssueEntity> findAll(String username);

	@Select("select issues.id, summary, description, priority from issues "
			+"left join priority on priorityId = priority.id where issues.id = #{id} "
			+ "order by priorityId")
	IssueEntity findById(int id);

	@Insert("insert into issues (summary, description, username, priorityId) "
			+ "values (#{summary}, #{desctiption}, #{username}, #{priorityId})")
	void create(@Param("summary")String summary, @Param("desctiption")String description,
			@Param("username")String username, @Param("priorityId") int priorityId);

	@Update("update issues set summary = #{summary}, description = #{description},"
			+ " priorityId = #{priorityId} where id = #{id}")
	void update(@Param("id")int id, @Param("summary") String summary,
			@Param("description") String description, @Param("priorityId")int priorityId);

	@Delete("delete from issues where id = #{id}")
	void delete(int id);

	@Select("select issues.id, summary, description, priority from issues "
			+"left join priority on priorityId = priority.id "
			+ "where summary like '%${keyword}%' and username = #{username}"
			+ "order by priorityId")
	List<IssueEntity> findByKeyword(@Param("keyword")String keyword, @Param("username")String username);
}
