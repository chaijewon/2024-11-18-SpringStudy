package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class DataBoardDAO {
   @Autowired
   private DataBoardMapper mapper;
   
   /*
    *   @Select("SELECT no,subject,name,TO_CHAR(regdate,'yyyy-MM-dd') as dbday,hit,replycount,num "
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
	    */
   public List<DataBoardVO> databoardListData(Map map)
   {
	   return mapper.databoardListData(map);
   }
   public int databoardTotalPage()
   {
	   return mapper.databoardTotalPage();
   }
   public void dataBoardInsert(DataBoardVO vo)
   {
	   mapper.dataBoardInsert(vo);
   }
}
