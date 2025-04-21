package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
   @Select("SELECT fno,poster,name,address,num "
		  +"FROM (SELECT fno,poster,name,address,rownum as num "
		  +"FROM (SELECT fno,poster,name,address "
		  +"FROM busan_food ORDER BY fno ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<FoodVO> busanFoodListData(
		   @Param("start") int start,
		   @Param("end") int end);
   @Select("SELECT CEIL(COUNT(*)/20.0) FROM busan_food")
   public int busanFoodTotalPage();
   
   @Select("SELECT * FROM busan_food "
		  +"WHERE fno=#{fno}")
   public FoodVO busanFoodDetailData(int fno);
}
