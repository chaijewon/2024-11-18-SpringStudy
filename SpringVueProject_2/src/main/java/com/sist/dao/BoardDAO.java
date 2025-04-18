package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class BoardDAO {
  @Autowired
  private BoardMapper mapper;
  
  /*
   *   @Select("SELECT no,subject,name,"
		 +"TO_CHAR(regdate,'yyyy-mm-dd') as dbday,hit, num "
		 +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		 +"FROM (SELECT no,subject,name,regdate,hit "
		 +"FROM vueBoard ORDER BY no DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
        public List<BoardVO> boardListData(Map map);
  
       @Select("SELECT CEIL(COUNT(*)/10.0) FROM vueBoard")
       public int boardTotalPage();
       
       DI => XML (p:~ c:~) @Autowired 
       AOP 
       MVC 
       ORM : MyBatis 
       Front 추가 
       =========================
       WebSocket / Security 
       URL = 일반 주소 *.do / PathVariable 
       =================================
        Spring - Boot 
   */
  public List<BoardVO> boardListData(Map map)
  {
	  return mapper.boardListData(map);
  }
  public int boardTotalPage()
  {
	  return mapper.boardTotalPage();
  }
}
