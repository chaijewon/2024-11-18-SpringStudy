package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.FoodVO;

public interface FoodRecipeService {
	public List<FoodVO> foodListData(Map map);
	public FoodVO foodDetailData(int fno);
	 
}
