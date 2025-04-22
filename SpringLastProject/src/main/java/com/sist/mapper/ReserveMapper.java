package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface ReserveMapper {
  @Select("SELECT fno,poster,name "
		 +"FROM busan_food ORDER BY fno ASC")
  public List<FoodVO> busanFoodReserveData();
}
