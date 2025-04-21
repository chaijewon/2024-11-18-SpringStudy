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
    *   @Select("SELECT fno,poster,name,replycount,likecount,hit,num "
		  +"FROM (SELECT fno,poster,name,replycount,likecount,hit,rownum as num "
		  +"FROM (SELECT fno,poster,name,replycount,likecount,hit "
		  +"FROM busan_food ORDER BY fno ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
		   public List<FoodVO> busanFoodListData(
				   @Param("start") int start,
				   @Param("end") int end);
		   @Select("SELECT CEIL(COUNT(*)/20.0) FROM busan_food")
		   public int busanFoodTotalPage();
    */
   public List<FoodVO> busanFoodListData(int start,int end)
   {
	   return mapper.busanFoodListData(start, end);
   }
   public int busanFoodTotalPage()
   {
	   return mapper.busanFoodTotalPage();
   }
   /*
    *   @Select("SELECT * FROM busan_food "
		  +"WHERE fno=#{fno}")
   public FoodVO busanFoodDetailData(int fno);
   
    */
   public FoodVO busanFoodDetailData(int fno)
   {
	   return mapper.busanFoodDetailData(fno);
   }
}
