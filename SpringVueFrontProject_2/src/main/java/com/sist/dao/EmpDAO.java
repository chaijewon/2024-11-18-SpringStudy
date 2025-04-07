package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
// 스프링 
/*
 *   1. DAO => Repository : table한개 제어 
 *   2. Service => Service : 관련된 DAO여러개 모아서 처리 
 *   3. Manager => Component : 일반 클래스 
 *   4. Model => Controller : 브라우저와 연결 
 *   ----------------------- 메모리 할당후 관리 
 */
@Repository
public class EmpDAO {
   // 구현을 스프링에서 구현 => 구현된 메모리 주소값 받기 
   @Autowired // 자동 주입 
   private EmpMapper mapper;
   
   public List<EmpVO> empListData()
   {
	   return mapper.empListData();
   }
   
   public List<DeptVO> deptListData()
   {
	   return mapper.deptListData();
   }
}
