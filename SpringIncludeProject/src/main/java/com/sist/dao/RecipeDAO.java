package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.RecipeVO;

@Repository
public class RecipeDAO {
  @Autowired
  private RecipeMapper mapper;
  /*
   *   @Select("SELECT no,poster,title,num "
		  +"FROM (SELECT no,poster,title,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk) +/no,poster,title "
		  +"FROM recipe "
		  +"WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail))) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<RecipeVO> recipeListData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) "
		  +"FROM recipe "
		  +"WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
   public int recipeTotalPage();
   */
  public List<RecipeVO> recipeListData(Map map)
  {
	  return mapper.recipeListData(map);
  }
  public int recipeTotalPage()
  {
	  return mapper.recipeTotalPage();
  }
}
