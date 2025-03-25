package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class BoardDAO {
   @Autowired
   private BoardMapper mapper;
   
   /*
    *   @Select("SELECT no,subject,name,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,num "
		 +"FROM (SELECT no,subject,name,hit,regdate,rownum as num "
		 +"FROM (SELECT no,subject,name,hit,regdate "
		 +"FROM freeboard ORDRE BY no DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
		  public List<BoardVO> boardListData(
				  @Param("start") int start,
				  @Param("end") int end);
		  // boardListData(1,10)
		  @Select("SELECT CEIL(COUNT(*)/10.0) FROM freeboard")
		  public int boardTotalPage();
    */
   public List<BoardVO> boardListData(int start,int end)
   {
	   return mapper.boardListData(start, end);
   }
   public int boardTotalPage()
   {
	   return mapper.boardTotalPage();
   }
   public void boardInsert(BoardVO vo)
   {
	   mapper.boardInsert(vo);
   }
   /*
    *   @Update("UPDATE freeboard SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
		  public void hitIncrement(int no);
		  @Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday "
				 +"FROM freeboard "
				 +"WHERE no=#{no}")
		  public BoardVO boardDetailData(int no);
    */
   public BoardVO boardDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.boardDetailData(no);
   }
   
   public BoardVO boardUpdateData(int no)
   {
	   return mapper.boardDetailData(no);
   }
   
}
