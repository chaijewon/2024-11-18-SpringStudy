package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
/*
 *   Vue / React / Next / Ajax 
 *   => 서버에서 데이터가 전송될때 동작 
 */
public interface SeoulMapper {
  @Select("SELECT no,title,poster,num "
		 +"FROM (SELECT no,title,poster,rownum as num "
		 +"FROM (SELECT no,title,poster "
		 +"FROM ${table_name} ORDER BY no ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<SeoulVO> seoulListData(Map map);
  // where 문장으로 변경 
  
  @Select("SELECT CEIL(COUNT(*)/12.0) "
		 +"FROM ${table_name}")
  public int seoulTotalPage(Map map);
  
  @Select("SELECT * FROM ${table_name} "
		 +"WHERE no=#{no}")
  public SeoulVO seoulDetailData(Map map);
  //                             int fno
  // $ => 일반 문자열을 사용할 수 없다 
  /*
   *   @Select("SELECT fno,name,poster,num "
		 +"FROM (SELECT fno,name,poster,rownum as num "
		 +"FROM (SELECT fno,name,poster "
		 +"FROM project_food "
		 +"WHERE type LIKE '%'||#{type}||'%' " 
		 +"ORDER BY fno ASC)) "
		 
		 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<FoodVO> foodListData(Map map);
	  // where 문장으로 변경 
	  
	  @Select("SELECT CEIL(COUNT(*)/12.0) "
			 +"FROM project_food "
			 +"WHERE type LIKE '%'||#{type}||'%')
	  public int foodTotalPage(Map map);
  // $ => 일반 문자열을 사용할 수 없다 
   */
}
