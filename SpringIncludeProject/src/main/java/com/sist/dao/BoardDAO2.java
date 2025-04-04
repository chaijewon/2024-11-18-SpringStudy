package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class BoardDAO2 {
   @Autowired
   private BoardMapper mapper;
   
   /*
    *   String sql1="SELECT no,subject,name,hit,regdate,num "
		    +"FROM (SELECT no,subject,name,hit,regdate,rownum as num "
		    +"FROM (SELECT no,subject,name,hit,regdate "
		    +"FROM springReplyBoard ORDER BY no DESC)) "
		    +"WHERE num BETWEEN #{start} AND #{end}";
	@Select(sql1)
	public List<BoardVO> boardListData(Map map);
	
	String sql2="SELECT COUNT(*) FROM springReplyBoard";
	@Select(sql2)
	public int boardRowCount();
	
	String sql3="INSERT INTO springReplyBoard("
		     +"no,name,subject,content,pwd,group_id) "
		     +"VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},"
		     +"(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))";
	@Insert(sql3)
	public void boardInsert(BoardVO vo);
	String sql4="UPDATE springReplyBoard SET "
		     +"hit=hit+1 "
		     +"WHERE no=#{no}";
	@Update(sql4)
	public void hitIncrement(int no);
	
	String sql5="SELECT no,name,subject,content,hit,regdate "
			   +"FROM springReplyBoard "
			   +"WHERE no=#{no}";
	@Select(sql5)
	public BoardVO boardDetailData(int no);
	
    */
   public List<BoardVO> boardListData(Map map)
   {
	   return mapper.boardListData(map);
   }
   public int boardRowCount()
   {
	   return mapper.boardRowCount();
   }
   public void boardInsert(BoardVO vo)
   {
	   mapper.boardInsert(vo);
   }
   
   @Transactional
   public BoardVO boardDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.boardDetailData(no);
   }
   
}
