package com.sist.spring2;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface EmpMapper {
  @Select("SELECT empno,ename,job,"
		 +"TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal "
		 +"FROM emp")
  public List<EmpVO> empAllData();
}
