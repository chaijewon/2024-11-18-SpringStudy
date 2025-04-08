package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
// project_food pf_fno_pk
public interface RecipeMapper {
  @Select("SELECT no,poster,title,num "
		 +"FROM (SELECT no,poster,title,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,poster,title "
		 +"FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail))) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<RecipeVO> recipeListData(@Param("start") int start,
		  @Param("end") int end);
  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
		 +"WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
  public int recipeTotalPage();
  
  @Select("SELECT no,poster,title,num "
			 +"FROM (SELECT no,poster,title,rownum as num "
			 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,poster,title "
			 +"FROM recipe WHERE title LIKE '%'||#{fd}||'%')) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<RecipeVO> recipeFindListData(Map map);
	  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
		 +"WHERE title LIKE '%'||#{fd}||'%'")
  public int recipeFindTotalPage(String fd);
  
  // 상세보기 
  @Select("SELECT * FROM recipeDetail "
		 +"WHERE no=#{no}")
  public RecipeDetailVO recipeDetailData(int no);
}
