package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class BoardDAO {
   @Autowired
   private BoardMapper mapper;
   
   @Autowired
   private BCryptPasswordEncoder encoder;
   
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
   /*
    *   @Select("SELECT pwd FROM freeboard "
		 +"WHERE no=#{no}")
		  public String boardGetPassword(int no);
		  
		  @Update("UPDATE freeboard SET "
				 +"name=#{name},subject=#{subject},"
				 +"content=#{content} "
				 +"WHERE no=#{no}")
		  public void boardUpdate(BoardVO vo);
    */
   public boolean boardUpdate(BoardVO vo)
   {
	   boolean bCheck=false;
	   String db_pwd=mapper.boardGetPassword(vo.getNo());
	   if(encoder.matches(vo.getPwd(), db_pwd))
	   {
		   mapper.boardUpdate(vo);
		   bCheck=true;
	   }
	   /*else
	   {
		   bCheck=false;   
	   }*/
	   return bCheck;
   }
   
   /*
    *   @Delete("DELETE FROM freeboard "
		 +"WHERE no=#{no}")
        public void boardDelete(int no);
    */
   public boolean boardDelete(int no,String pwd)
   {
	   boolean bCheck=false;
	   String db_pwd=mapper.boardGetPassword(no);
	   if(encoder.matches(pwd, db_pwd))
	   {
		   bCheck=true;
		   mapper.boardDelete(no);
	   }
	   return bCheck;
   }
   
}
