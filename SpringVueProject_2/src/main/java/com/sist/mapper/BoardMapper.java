package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
  
  @Insert("INSERT INTO vueBoard(no,name,subject,content,pwd) "
		 +"VALUES(vue_no_seq.nextval,#{name},#{subject},"
		 +"#{content},#{pwd})")
  public void boardInsert(BoardVO vo);
  
  @Update("UPDATE vueBoard SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
  public void hitIncrement(int no);
  
  @Select("SELECT no,name,subject,content,hit,"
		 +"TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday "
		 +"FROM vueBoard "
		 +"WHERE no=#{no}")
  public BoardVO boardDetailData(int no);
}
