package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
/*
 *   Component / computed / watch 
 *   Spring-Boot => gradle 
 *   ---------------------- 
 */
public interface VueMapper {
   // Food 
   @Select("SELECT fno,name,poster,num "
		  +"FROM (SELECT fno,name,poster,rownum as num "
		  +"FROM (SELECT fno,name,poster "
		  +"FROM project_food ORDER BY fno ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<FoodVO> foodListData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
   public int foodTotalPage();
   
   @Select("SELECT * FROM project_food "
		  +"WHERE fno=#{fno}")
   public FoodVO foodDetailData(int fno);
   // Goods => computed 
   // Recipe => component : pagination => js
}
