package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			 +"FROM (SELECT fno,name,poster,rownum as num "
			 +"FROM (SELECT fno,name,poster "
			 +"FROM project_food "
			 +"WHERE type LIKE '%'||#{type}||'%' " 
			 +"ORDER BY fno ASC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
     public List<FoodVO> foodListData(Map map);
		  // where 문장으로 변경 
		  
	@Select("SELECT CEIL(COUNT(*)/12.0) "
		   +"FROM project_food "
		   +"WHERE type LIKE '%'||#{type}||'%'")
	public int foodTotalPage(Map map);
}
