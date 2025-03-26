package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class FoodDAO {
  @Autowired
  private FoodMapper mapper;
  
  /*
   *   @Select("SELECT * FROM project_food "
		 +"WHERE fno=#{fno}")
  public FoodVO foodDetailData(int fno);
  
  @Select("SELECT fno,poster,name,type,num "
		 +"FROM (SELECT fno,poster,name,type,rownum as num "
		 +"FROM (SELECT + INDEX_ASC(project_food fm_fno_pk) fno,poster,name,type "
		 +"FROM project_food)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<FoodVO> foodListData(Map map);
   */
  public List<FoodVO> foodListData(Map map)
  {
	  return mapper.foodListData(map);
  }
  public FoodVO foodDetailData(int fno)
  {
	  mapper.hitIncrement(fno);
	  return mapper.foodDetailData(fno);
  }
  public int foodTotalPage()
  {
	  return mapper.foodTotalPage();
  }
}
