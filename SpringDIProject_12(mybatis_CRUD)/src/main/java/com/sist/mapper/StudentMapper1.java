package com.sist.mapper;
/*
 *   <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.sist.mapper.student-mapper">
  <!-- 
       ������ SQL���� = XML
           +
       �ܼ��� SQL���� = Annotation
       <select>
         SELECT ~
         WHERE 
          <if test="">
            name LIKE...
          </if>
          <if test="">
            subject LIKE...
          </if>
          <if test="">
            content LIKE...
          </if>
       </select>
       
       @Select("{<script>"
         +...
         +"<if test=\"\">"
       +"</script>}")
   -->
   <!-- ��� / �󼼺��� : SELECT : READ-->
   <!-- ��� : INSERT : CREATE-->
   <!-- ���� : UPDATE : UPADTE-->
   <!-- ���� : DELETE : DELETE -->
   <!-- @Select() -->
   <select id="studentListData" resultType="StudentVO">
     SELECT * FROM student
   </select>
   <select id="studentDetailData" resultType="StudentVO" parameterType="int">
     SELECT * FROM student
     WHERE hakbun=#{hakbun}
   </select>
   <!-- @Insert() -->
   <insert id="studentInsert" parameterType="StudentVO">
     <!-- @SelectKey -->
     <selectKey keyProperty="hakbun" resultType="int" order="BEFORE">
      SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student
     </selectKey>
     INSERT INTO student VALUES(
       #{hakbun},#{name},#{kor},#{eng},#{math}
     )
   </insert>
   <!-- @Delete -->
   <delete id="studentDelete" parameterType="int">
     DELETE FROM student
     WHERE hakbun=#{hakbun}
   </delete>
   <!-- @Update -->
   <update id="studentUpdate" parameterType="StsudentVO">
     UPDATE student SET
     name=#{name},kor=#{kor},eng=#{eng},math=#{math}
     WHERE hakbun=#{hakbun}
   </update>
</mapper>

 */
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface StudentMapper1 {
   /*
    *    <select id="studentListData" resultType="StudentVO">
		     SELECT * FROM student
		   </select>
		   <select id="studentDetailData" resultType="StudentVO" parameterType="int">
		     SELECT * FROM student
		     WHERE hakbun=#{hakbun}
		   </select>
    */
	@Select("SELECT * FROM student")
	public List<StudentVO> studentListData();
	
	@Select("SELECT * FROM student "
		   +"WHERE hakbun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);
	
	/*
	 *   <insert id="studentInsert" parameterType="StudentVO">
	     <!-- @SelectKey -->
	     <selectKey keyProperty="hakbun" resultType="int" order="BEFORE">
	      SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student
	     </selectKey>
	     INSERT INTO student VALUES(
	       #{hakbun},#{name},#{kor},#{eng},#{math}
	     )
	   </insert>
	 */
	// Sequence / subquery
	@SelectKey(keyProperty = "hakbun",
			   resultType = int.class, before = true,
			   statement = "SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student") 
	@Insert("INSERT INTO student VALUES("
			+ "#{hakbun},#{name},#{kor},#{eng},#{math})")
	public void studentInsert(StudentVO vo);
	
	/*
	 *   <delete id="studentDelete" parameterType="int">
		     DELETE FROM student
		     WHERE hakbun=#{hakbun}
		   </delete>
	 */
	@Delete("DELETE FROM student WHERE hakbun=#{hakbun}")
	public void studentDelete(int hakbun);
	
	/*
	 *   <update id="studentUpdate" parameterType="StsudentVO">
     UPDATE student SET
     name=#{name},kor=#{kor},eng=#{eng},math=#{math}
     WHERE hakbun=#{hakbun}
   </update>
	 */
	@Update("UPDATE student SET "
			+ "name=#{name},kor=#{kor},eng=#{eng},math=#{math} "
			+ "WHERE hakbun=#{hakbun}")
	public void studentUpdate(StudentVO vo);
}
