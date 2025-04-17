package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface RecipeMapper {
   @Select("SELECT no,poster,title,num "
		  +"FROM (SELECT no,poster,title,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,poster,title "
		  +"FROM recipe WHERE no IN(SELECT no FROM recipe  "
		  +"INTERSECT SELECT no FROM recipeDetail))) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<RecipeVO> recipeListData(@Param("start") int start,
		   @Param("end") int end);
   @Select("SELECT COUNT(*) FROM recipe "
		  +"WHERE no IN(SELECT no FROM recipe "
		  +"INTERSECT SELECT no FROM recipeDetail)")
   public int recipeTotalPage();
   
   @Select("SELECT * FROM recipedetail "
		  +"WHERE no=#{no}")
   public RecipeDetailVO recipeDetailData(int no);
}
