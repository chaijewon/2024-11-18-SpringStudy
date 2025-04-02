package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface RecipeMapper {
   @Select("SELECT no,poster,title,num "
		  +"FROM (SELECT no,poster,title,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk) */no,poster,title "
		  +"FROM recipe "
		  +"WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail))) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<RecipeVO> recipeListData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) "
		  +"FROM recipe "
		  +"WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
   public int recipeTotalPage();
   
}
