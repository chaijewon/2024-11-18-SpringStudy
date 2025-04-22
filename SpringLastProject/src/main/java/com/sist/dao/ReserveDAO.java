package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class ReserveDAO {
  @Autowired
  private ReserveMapper mapper;
  
  /*
   *   @Select("SELECT fno,poster,name "
		 +"FROM busan_food ORDER BY fno ASC")
       public List<FoodVO> busanFoodReserveData();
   */
  public List<FoodVO> busanFoodReserveData()
  {
	  return mapper.busanFoodReserveData();
  }
}
