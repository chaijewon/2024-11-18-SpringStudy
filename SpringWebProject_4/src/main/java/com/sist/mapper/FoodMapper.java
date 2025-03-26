package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
  @Select("SELECT * FROM project_food "
		 +"WHERE fno=#{fno}")
  public FoodVO foodDetailData(int fno);
  
  @Select("SELECT fno,poster,name,type,num "
		 +"FROM (SELECT fno,poster,name,type,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(project_food fm_fno_pk)*/fno,poster,name,type "
		 +"FROM project_food)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<FoodVO> foodListData(Map map);
}



