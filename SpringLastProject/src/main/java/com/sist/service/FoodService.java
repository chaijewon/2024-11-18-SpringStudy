package com.sist.service;
import java.util.*;
import com.sist.vo.*;
/*
 *    Model(Controller) ==== Service ==== DAO 
 *                           
 */
public interface FoodService {
	public List<FoodVO> busanFoodListData(int start,int end);
	public int busanFoodTotalPage();
}
