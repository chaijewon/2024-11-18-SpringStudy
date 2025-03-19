package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface EmpMapper {
  @Select("SELECT ename,job,sal FROM emp")
  public List<EmpVO> empListData();
}
