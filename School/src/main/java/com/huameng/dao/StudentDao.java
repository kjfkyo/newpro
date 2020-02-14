package com.huameng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.huameng.bean.Student;
import com.huameng.mybatis.Page;

public interface StudentDao {
	@Insert("insert into student values(s_seq.nextval,#{s_name},#{s_age},#{cid.c_id})")
	public int insertStudent(Student student);
	@Delete("delete from student where s_id=#{s_id}")
	public int deleteStudentById(int s_id);
	
	public int updateStudent(Student student);
	
	public Student selectStudentById(int s_id);
	
	public List<Student> selectStudentPageCount
	(@Param("pageCount")int pageCount,@Param("pageSize")int pageSize);
	
	@Select("select count(*) from student")
	public int selectCount();
	
	public List<Student> selectStudentPageAll(Page<Student> page);
}
