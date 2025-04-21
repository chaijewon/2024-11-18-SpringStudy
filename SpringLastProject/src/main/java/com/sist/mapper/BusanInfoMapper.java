package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface BusanInfoMapper {
  @Select("SELECT no,poster,title,address,phone,num "
		 +"FROM (SELECT no,poster,title,address,phone,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(busan_info bi_no_pk)*/no,poster,title,address,phone "
		 +"FROM busan_info WHERE cno=#{cno})) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<BusanInfoVO> busanInfoListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM busan_info "
		 +"WHERE cno=#{cno}")
  public int busanInfoTotalPage(int cno);
}
