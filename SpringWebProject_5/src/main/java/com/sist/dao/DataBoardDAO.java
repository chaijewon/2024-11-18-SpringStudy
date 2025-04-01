package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    *    @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday, num "
		  +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		  +"FROM (SELECT no,subject,name,regdate,hit "
		  +"FROM springDataBoard ORDER BY no DESC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
		   public List<DataBoardVO> boardListData(@Param("start") int start,
				   @Param("end") int end);
		   // boardListData(1,10)
		   @Select("SELECT COUNT(*) FROM springDataBoard")
		   public int boardRowCount();
		   
		   @Insert("INSERT INTO springDataBoard VALUES("
				  +"sdb_no_seq.nextval,#{name},"
				  +"#{subject},#{content},#{pwd},"
				  +"SYSDATE,0,#{filecount}")
		   public int boardInsert(DataBoardVO vo);
    */
   public List<DataBoardVO> boardListData(int start,int end)
   {
	   return mapper.boardListData(start, end);
   }
   public int boardRowCount()
   {
	   return mapper.boardRowCount();
   }
   public int boardInsert(DataBoardVO vo)
   {
	   mapper.boardInsert(vo);
	   return mapper.boardCurentNoData();// 현재 번호 
   }
   
   /*
    *   @Update("UPDATE springDataBoard SET "
		  +"hit=hit+1 "
		  +"WHERE no=#{no}")
	   public void hitIncrement(int no);
	   
	   @Select("SELECT * FROM springdataboard "
			  +"WHERE no=#{no}")
	   public DataBoardVO databoardDetailData(int no);
    */
   public DataBoardVO databoardDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.databoardDetailData(no);
   }
}
