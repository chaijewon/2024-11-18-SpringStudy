package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
// Vue => Nuxt.js 
// React => Next.js
@Repository
public class SeoulDAO {
  @Autowired
  private SeoulMapper mapper;
  
  /*
   *   @Select("SELECT no,poster,title,num "
			  +"FROM (SELECT no,poster,title,rownum as num "
			  +"FROM (SELECT no,poster,title "
			  +"FROM ${table_name} ORDER BY fno ASC)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")
		public List<SeoulVO> seoulListData(Map map);
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM ${table_name}")
		public int seoulTotalPage(Map map);
   */
  public List<SeoulVO> seoulListData(Map map)
  {
	  return mapper.seoulListData(map);
  }
  public int seoulTotalPage(Map map)
  {
	  return mapper.seoulTotalPage(map);
  }
  /*
   *   @Select("SELECT fno,poster,name,rownum "
		   +"FROM (SELECT fno,poster,name "
		   +"FROM project_food "
		   +"WHERE address LIKE '%'||#{address}||'%' "
		   +"ORDER BY hit DESC) "
		   +"WHERE rownum<=8")
	   public List<FoodVO> foodRecommandData(String address);
   */
  public List<FoodVO> foodRecommandData(String address)
  {
	  return mapper.foodRecommandData(address);
  }
  /*
   *   @Select("SELECT * FROM seoul_location "
		   +"WHERE no=#{no}")
	   public SeoulVO seoulLocationDetailData(int no);
   */
  public SeoulVO seoulLocationDetailData(int no)
  {
	  return mapper.seoulLocationDetailData(no);
  }
}
