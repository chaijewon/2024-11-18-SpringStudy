package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface BoardMapper {
  @Select("SELECT no,subject,name,"
		 +"TO_CHAR(regdate,'yyyy-mm-dd') as dbday,hit, num "
		 +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		 +"FROM (SELECT no,subject,name,regdate,hit "
		 +"FROM vueBoard ORDER BY no DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<BoardVO> boardListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/10.0) FROM vueBoard")
  public int boardTotalPage();
}
