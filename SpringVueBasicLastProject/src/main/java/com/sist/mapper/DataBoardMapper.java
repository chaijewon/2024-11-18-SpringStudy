package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

import lombok.EqualsAndHashCode.Include;
public interface DataBoardMapper {
   @Select("SELECT no,subject,name,TO_CHAR(regdate,'yyyy-MM-dd') as dbday,hit,replycount,num "
		  +"FROM (SELECT no,subject,name,regdate,hit,replycount,rownum as num "
		  +"FROM (SELECT no,subject,name,regdate,hit,replycount "
		  +"FROM vueDataBoard ORDER BY no DESC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   // 인라인뷰 단점 => Top-N
   public List<DataBoardVO> databoardListData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/10.0) FROM vueDataBoard")
   public int databoardTotalPage();
   
   @Insert("INSERT INTO vueDataBoard VALUES("
		  +"vb_no_seq.nextval,#{name},"
		  +"#{subject},#{content},#{pwd},"
		  +"SYSDATE,0,#{filename},#{filesize},"
		  +"#{filecount},0)")
   public void dataBoardInsert(DataBoardVO vo);
   
   @Update("UPDATE vueDataBoard SET "
		  +"hit=hit+1 "
		  +"WHERE no=#{no}")
   public void hitIncrement(int no);
   
   @Select("SELECT no,name,subject,content,hit, "
		  +"TO_CHAR(regdate,'yyyy-MM-dd') as dbday, "
		  +"filename,filesize,filecount "
		  +"FROM vueDataBoard "
		  +"WHERE no=#{no}")
   public DataBoardVO databoardDetailData(int no);
}
