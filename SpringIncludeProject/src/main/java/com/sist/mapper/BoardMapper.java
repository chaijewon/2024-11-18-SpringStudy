package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface BoardMapper {
	String sql1="SELECT no,subject,name,hit,regdate,num "
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
	
	
  
}
