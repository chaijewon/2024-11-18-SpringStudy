package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface EmpMapper {
   @Select("SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
		  +"FROM emp")
   public List<EmpVO> empListData();
   
   
   @Select("SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
		  +"FROM emp "
		  +"WHERE empno=#{empno}")
   public EmpVO empDetailData(int empno);
   /*
    *   <select id="empDetailData" resultType="EmpVO" parameterType="int">
    *    SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday
    *    FROM emp
    *    WHERE empno=#{empno}
    *   </select>
    */
   // 조인 처리 
   /*
    *  <resultMap type="" id="">
    *   <result property="" column=""/>
    *  </resultMap>
    */
   @Results({
	   @Result(property = "dvo.dname",column = "dname"),
	   @Result(property = "dvo.loc",column = "loc")
   })
   @Select("SELECT empno,ename,job,sal,dname,loc "
		  +"FROM emp,dept "
		  +"WHERE emp.deptno=dept.deptno")
   public List<EmpVO> empJoinData();
}
