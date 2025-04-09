package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
  @Autowired
  private FoodMapper mapper;
  
  public List<FoodVO> foodListData(Map map)
  {
	  return mapper.foodListData(map);
  }
  public int foodTotalPage(Map map)
  {
	  return mapper.foodTotalPage(map);
  }
}
