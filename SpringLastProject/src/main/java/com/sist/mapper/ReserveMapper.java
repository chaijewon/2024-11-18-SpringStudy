package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
/*
 *   rno NUMBER,
     fno NUMBER,
     userid VARCHAR2(20),
     rday VARCHAR2(30) CONSTRAINT br_rday_nn NOT NULL,
     rtime VARCHAR2(30) CONSTRAINT br_rtime_nn NOT NULL,
     rinwon VARCHAR2(20) CONSTRAINT br_rinwon_nn NOT NULL,
     regdate DATE DEFAULT SYSDATE,
     isreserve NUMBER DEFAULT 0
 */
public interface ReserveMapper {
  @Select("SELECT fno,poster,name "
		 +"FROM busan_food ORDER BY fno ASC")
  public List<FoodVO> busanFoodReserveData();
  
  @Insert("INSERT INTO busanReserve(rno,fno,userid,rday,rtime,rinwon) "
		 +"VALUES(br_rno_seq.nextval,#{fno},"
		 +"#{userid},#{rday},#{rtime},#{rinwon})")
  public void reserveInsert(ReserveVO vo);
  // <resultMap>
  @Results({
	  @Result(property = "fvo.poster",column = "poster"),
	  @Result(property = "fvo.name",column = "name")
  })
  @Select("SELECT rno,br.fno,poster,name,rday,rtime,rinwon,"
		 +"TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,"
		 +"isReserve "
		 +"FROM busanReserve br,busan_food bf "
		 +"WHERE br.fno=bf.fno "
		 +"AND userid=#{userid} "
		 +"ORDER BY rno DESC")
  public List<ReserveVO> reserveMyPageListData(String userid);
  
  @Results({
	  @Result(property = "fvo.poster",column = "poster"),
	  @Result(property = "fvo.name",column = "name")
  })
  @Select("SELECT rno,br.fno,userid,poster,name,rday,rtime,rinwon,"
		 +"TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,"
		 +"isReserve "
		 +"FROM busanReserve br,busan_food bf "
		 +"WHERE br.fno=bf.fno "
		 +"ORDER BY rno DESC")
  public List<ReserveVO> reserveAdminPageListData();
  
  @Delete("DELETE FROM busanReserve "
		 +"WHERE rno=#{rno}")
  public void reserveDelete(int rno);
  
  @Update("UPDATE busanReserve SET "
		 +"isReserve=1 "
		 +"WHERE rno=#{rno}")
  public void reserveUpdate(int rno);
  
}
