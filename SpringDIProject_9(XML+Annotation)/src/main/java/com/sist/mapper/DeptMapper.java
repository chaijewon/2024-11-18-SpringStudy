package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface DeptMapper {
   // public List<DeptVO> findAll() findNameLike
   @Select("SELECT * FROM dept")
   public List<DeptVO> deptListData();
}
