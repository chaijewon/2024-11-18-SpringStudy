package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class VueDAO {
   @Autowired
   private VueMapper mapper;
   
   /*
    *   @Select("SELECT fno,name,poster,num "
		  +"FROM (SELECT fno,name,poster,rownum as num "
		  +"FROM (SELECT fno,name,poster "
		  +"FROM project_food ORDER BY fno ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
        public List<FoodVO> foodListData(Map map);
    */
   public List<FoodVO> foodListData(Map map)
   {
	   return mapper.foodListData(map);
   }
   /*
    *   @Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
        public int foodTotalPage();
    */
   public int foodTotalPage()
   {
	   return mapper.foodTotalPage();
   }
   /*
    *   @Select("SELECT * FROM project_food "
		  +"WHERE fno=#{fno}")
        public FoodVO foodDetailData(int fno);
    */
   public FoodVO foodDetailData(int fno)
   {
	   return mapper.foodDetailData(fno);
   }
   
}
