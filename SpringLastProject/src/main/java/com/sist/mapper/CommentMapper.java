package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface CommentMapper {
  // 목록
  @Select("SELECT no,cno,type,userid,username,sex,msg,"
		 +"group_id,group_step,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,num "
		 +"FROM (SELECT no,cno,type,userid,username,sex,msg,"
		 +"group_id,group_step,regdate,rownum as num "
		 +"FROM (SELECT no,cno,type,userid,username,sex,msg,"
		 +"group_id,group_step,regdate "
		 +"FROM busanReply WHERE cno=#{cno} AND type=#{type} "
		 +"ORDER BY group_id DESC , group_step ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<CommentVO> commentListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/10.0) FROM busanReply "
		 +"WHERE cno=#{cno} AND type=#{type}")
  public int commentTotalPage(@Param("cno") int cno,
		   @Param("type") int type);
  // 글쓰기
  @Insert("INSERT INTO busanReply(no,cno,type,userid,username,sex,msg,group_id) "
		 +"VALUES((SELECT NVL(MAX(no)+1,1) FROM busanReply),"
	     +"#{cno},#{type},#{userid},#{username},"
		 +"#{sex},#{msg},(SELECT NVL(MAX(group_id)+1,1) FROM busanReply))")
  public void commenInsert(CommentVO vo);
  // 수정 
  @Update("UPDATE busanReply SET "
		 +"msg=#{msg} "
		 +"WHERE no=#{no}")
  public void commentUpdate(@Param("msg") String msg,
		  @Param("no") int no);
  // 삭제 => group_id
  @Delete({"<script>"
	  +"DELETE FROM busanReply "  
	  +"WHERE "
	  +"<if test=\"group_step==0\">"
	  +"group_id=#{group_id}"
	  +"</if>"
	  +"<if test=\"group_step!=0\">"
	  +"no=#{no}"
	  +"</if>"
	  +"</script>"
  })
  public void commentDelete(Map map);
  
  
  // 대댓글
  /*
   *                group_id  group_step
   *   AAAAA           1         0   
   *     = KKKKK       1         1
   *     = BBBBB       1         2
   *     = CCCCC       1         3
   *     = DDDDD       1         4
   *  
   */
  @Select("SELECT group_id,group_step "
		 +"FROM busanReply "
		 +"WHERE no=#{no}")
  public CommentVO commentParentInfoData(int no);
  
  @Update("UPDATE busanReply SET "
		 +"group_step=group_step+1 "
		 +"WHERE group_id=#{group_id} AND group_step>#{group_step}")
  public void commentGroupStepIncrement(CommentVO vo);
  
  @Insert("INSERT INTO busanReply(no,cno,type,userid,username,sex,msg,group_id,group_step) "
		  +"VALUES((SELECT NVL(MAX(no)+1,1) FROM busanReply),"
		  +"#{cno},#{type},#{userid},#{username},"
		  +"#{sex},#{msg},#{group_id},"
		  +"#{group_step})")
  public void commentReplyReplyInsert(CommentVO vo);
  
  
}






