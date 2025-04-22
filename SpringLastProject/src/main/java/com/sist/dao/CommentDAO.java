package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
  
}
