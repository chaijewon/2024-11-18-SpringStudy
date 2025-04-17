package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
   @Autowired
   private FoodMapper mapper;
   
   /*
    *   @Select("SELECT fno,poster,name,num "
			  +"FROM (SELECT fno,poster,name,rownum as num "
			  +"FROM (SELECT fno,poster,name "
			  +"FROM project_food ORDER BY fno ASC)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")
	   public List<FoodVO> foodListData(@Param("start") int start,
			   @Param("end") int end);
	   @Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
	   public int foodTotalPage();
    */
   public List<FoodVO> foodListData(int start,int end)
   {
	   return mapper.foodListData(start, end);
   }
   public int foodTotalPage()
   {
	   return mapper.foodTotalPage();
   }
}
