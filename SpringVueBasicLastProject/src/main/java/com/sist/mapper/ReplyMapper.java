package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.sist.vo.*;
public interface ReplyMapper {
  @Select("SELECT no,bno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,group_tab "
		 +"FROM vueReply "
		 +"WHERE bno=#{bno} "
		 +"ORDER BY group_id DESC,group_step ASC")
  public List<ReplyVO> replyListData(int bno);
  
  @SelectKey(keyProperty = "no",resultType = int.class,
		  before = true , 
		  statement = "SELECT NVL(MAX(no)+1,1) as no FROM vueReply")
  @Insert("INSERT INTO vueReply(no,bno,id,name,msg,group_id) "
		  +"VALUES(#{no},#{bno},#{id},#{name},#{msg},"
		  +"(SELECT NVL(MAX(group_id)+1,1) FROM vueReply))")
  public void replyInsert(ReplyVO vo);
  
}
