package com.sist.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.ChefVO;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;
/*
 *   유지보수 => Java / Spring 
 */
public interface RecipeService {
	public List<RecipeVO> recipeListData(Map map);
	public int recipeTotalPage();
	public RecipeDetailVO recipeDetailData(int no);
	public List<RecipeVO> recipeFindData(Map map);
	   //        resultType      id         parameterType
	public int recipeFindTotalPage(Map map);
	public List<ChefVO> chefListData(Map map);
	public int chefTotalPage();
}
