package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sist.manager.*;
import com.sist.mapper.CommentMapper;
import com.sist.vo.*;
@Repository
public class CommentDAO {
  @Autowired 
  private CommentMapper mapper;
  
  /*
   *   @Select("SELECT no,cno,type,userid,username,sex,msg,"
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
   */
  public List<CommentVO> commentListData(Map map)
  {
	  return mapper.commentListData(map);
  }
  public int commentTotalPage(int cno,int type)
  {
	  return mapper.commentTotalPage(cno, type);
  }
  public void commenInsert(CommentVO vo)
  {
	  mapper.commenInsert(vo);
  }
  /*
   *   @Update("UPDATE busanReply SET "
		 +"msg=#{msg} "
		 +"WHERE no=#{no}")
       public void commentUpdate(@Param("msg") String msg,
		  @Param("no") int no);
   */
  public void commentUpdate(String msg,int no)
  {
	  mapper.commentUpdate(msg, no);
  }
  /*
   *   @Select("SELECT group_id,group_step "
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
   */
  @Transactional
  public void commentReplyReplyInsert(int pno,CommentVO vo)
  {
	  CommentVO pvo=mapper.commentParentInfoData(pno);
	  vo.setGroup_id(pvo.getGroup_id());
	  vo.setGroup_step(pvo.getGroup_step()+1);
	  
	  mapper.commentGroupStepIncrement(pvo);
	  mapper.commentReplyReplyInsert(vo);
  }
  /*
   *   @Delete({"<script>"
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
   */
  public void commentDelete(int no)
  {
	  CommentVO vo=mapper.commentParentInfoData(no);
	  System.out.println(vo.getGroup_id());
	  System.out.println(vo.getGroup_step());
	  Map map=new HashMap();
	  map.put("no", no);
	  map.put("group_id", vo.getGroup_id());
	  map.put("group_step", vo.getGroup_step());
	  
	  mapper.commentDelete(map);
  }
}
