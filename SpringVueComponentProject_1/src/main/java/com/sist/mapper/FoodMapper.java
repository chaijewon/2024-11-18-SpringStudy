package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;
public interface FoodMapper {
   /*
    *   <select id="foodFindData" resultType="FoodVO" 
        parameterType="hashmap">
    */
	public List<FoodVO> foodFindData(Map map);
}
