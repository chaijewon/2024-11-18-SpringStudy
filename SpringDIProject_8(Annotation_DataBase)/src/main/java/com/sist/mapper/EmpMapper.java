package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface EmpMapper {
  // 목록 출력 
  @Select("SELECT empno,ename,job,hiredate,sal "
		 +"FROM emp")
  public List<EmpVO> empListData();
  
  @Select("SELECT empno,ename,job,hiredate,sal "
		 +"FROM emp "
		 +"WHERE empno=#{empno}")
  public EmpVO empDetailData(int empno);
  //               id="empDetailData"        parameterType="int"
  //     resultType="EmpVO"
  
  // @Insert @Update @Delete
}
