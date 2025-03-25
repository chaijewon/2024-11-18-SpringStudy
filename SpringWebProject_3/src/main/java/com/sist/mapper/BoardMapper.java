package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface BoardMapper {
  @Select("SELECT no,subject,name,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,num "
		 +"FROM (SELECT no,subject,name,hit,regdate,rownum as num "
		 +"FROM (SELECT no,subject,name,hit,regdate "
		 +"FROM freeboard ORDER BY no DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<BoardVO> boardListData(
		  @Param("start") int start,
		  @Param("end") int end);
  // boardListData(1,10)
  @Select("SELECT CEIL(COUNT(*)/10.0) FROM freeboard")
  public int boardTotalPage();
  // 리턴형 : resultType , 매개변수 : parameterType
  // 메소드명 : ID명칭 
  /*
   *    <select id="empListData" resultType="EmpVO"
   *     parameterType="hashmap">
   *     SELECT * FROM emp => row여부 여러개 
   *     WHERE num BETWEEN #{start} AND #{end}
   *    </select>
   *    public List<EmpVO> empListData(Map map)
   *           ===========
   *            selectList selectOne
   *    => 등록 : 한파일로 여러명 동시에 사용 
   *    => 등록 없이 개발자 각자 처리 : 어노테이션
   *    => application.xml
   *       ================ (X) => 자바로 환경 설정  
   */
  // 상세보기
  @Update("UPDATE freeboard SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
  public void hitIncrement(int no);
  @Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday "
		 +"FROM freeboard "
		 +"WHERE no=#{no}")
  public BoardVO boardDetailData(int no);
  
  // Spring-Boot : MySQL / JPA 
  // 추가 
  @Insert("INSERT INTO freeboard VALUES("
		 +"(SELECT NVL(MAX(no)+1,1) FROM freeboard),"
		 +"#{name},#{subject},#{content},#{pwd},"
		 +"SYSDATE,0)")
  public void boardInsert(BoardVO vo);
  // 수정 
  // 삭제 
  
}
