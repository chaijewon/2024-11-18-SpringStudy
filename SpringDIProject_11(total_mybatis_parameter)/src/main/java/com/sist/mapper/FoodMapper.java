package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
  // ¸ñ·Ï 
  @Select("SELECT fno,name,type,num "
		 +"FROM (SELECT fno,name,type,rownum as num "
		 +"FROM (SELECT fno,name,type "
		 +"FROM project_food ORDER BY fno ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  // public List<FoodVO> foodListData(Map map);
  // foodListData(1,10)
  public List<FoodVO> foodListData(@Param("start") int start,
		               @Param("end") int end);
  // JPA
  
  @Select("SELECT CEIL(COUNT(*)/10.0) FROM project_food")
  public int foodTotalPage();
  
}
