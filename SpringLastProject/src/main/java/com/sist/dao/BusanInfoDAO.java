package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
/*
 *   스프링 메모리 할당 
 *   => 패키지 단위 
 *      <context:component-scan basepackage="com.sist.*">
 *      => 선택적으로 메모리 할당 
 *      => 어노테이션 
 *   => @Component : 일반 객체 
 *                   ~Manager 
 *      @Repository : ~DAO (저장소)
 *      @Service : ~Service = 의존성을 낮게 
 *                 DAO 여러개를 묶어서 사용 
 *      @Controller : Model => 화면 변경 
 *      @RestController : Model => RestFul 
 *                        자바스크립트 / 코틀린 / 장고
 *      @ControllerAdvice : 공통 예외처리 => Controller
 *      @RestControllerAdvice : 공통 예외처리 => RestController
 *     
 *      @Bean 
 */
// model == service === dao == 오라클 연동 

public class BusanInfoDAO {
  @Autowired
  // 스프링에서 메모리 할당을 한 클래스의 주소을 받는 경우 => 클래스 객체 주소만 받을 수 있다
  private BusanInfoMapper mapper;
  
  // 구현 
  /*
   *   MyBatis : XML , Annotation 
   *             => XML + Annotation 
   *                      === 간단한 SQL
   *                === 동적 쿼리 / SQL문장이 긴 경우 
   *             => <select> @Select()
   *             => id resultType  parameterType 
   *                 |     |               |
   *               메소드명  리턴형            매개변수 
   *                      ====
   *                       VO / List
   *                        |    |
   *                             selectList
   *                     selectOne
   *             => getConnection / disConnection 처리
   *    => ORM => 관계형 데이터베이스에 대한 라이브러리 (데이터베이스)
   *        | MyBatis (IBatis)
   *        | JPA (Hibernate) => DataSet => LinQ
   */
     /*@Select("SELECT no,poster,title,num "
			 +"FROM (SELECT no,poster,title,rownum as num "
			 +"FROM (SELECT + INDEX_ASC(busan_info bi_no_pk)no,poster,title "
			 +"FROM busan_info WHERE cno=#{cno})) "
			 +"WHERE num BETWEEN #{start} AND #{end}")*/
	  public List<BusanInfoVO> busanInfoListData(Map map)
	  {
		  return mapper.busanInfoListData(map);
		  // MyBatis에서 구현된 메소드 호출 
	  }
	  
	  /*@Select("SELECT CEIL(COUNT(*)/12.0) FROM busan_info "
			 +"WHERE cno=#{cno}")*/
	  public int busanInfoTotalPage(int cno)
	  {
		  return mapper.busanInfoTotalPage(cno);
	  }
}
