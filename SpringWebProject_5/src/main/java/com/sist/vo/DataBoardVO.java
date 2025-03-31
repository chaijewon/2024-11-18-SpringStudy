package com.sist.vo;
/*
 *      NO        NOT NULL NUMBER         
		NAME      NOT NULL VARCHAR2(52)   
		SUBJECT   NOT NULL VARCHAR2(4000) 
		CONTENT   NOT NULL CLOB           
		PWD       NOT NULL VARCHAR2(10)   
		REGDATE            DATE           
		HIT                NUMBER         
		FILECOUNT          NUMBER
		
		1. 유지보수 => 한번에 처리 
		   1) 공통으로 적용하는 코드 => @Aspect
		   2) 공통으로 처리하는 예외처리 => @ControllerAdvice 
		2. DAO / SQL 
		3. Model에서 전송 
		   ------ 사용자값 받기 / 전송하는 값 
		          | 매개변수    | Model 
		4. JSP는 변경이 없다 
		   ------------- Front (VueJS)
 */

import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
// 일반 JDBC => 컬럼명과 VO의 변수명이 일치하지 않을 수 있다 
// MyBatis / JPA => 1. 변수/컬럼 일치 
//                     ---------- as / resultMap
// int fc;    select filecount
// => (DataBoardVO vo) => 업로드파일까지 값을 채워 온다
// name="name" => <input type=file name="files[0]">
public class DataBoardVO {
   private int no,hit,filecount;
   private String name,subject,content,pwd,dbday;
   private Date regdate;
   private List<MultipartFile> files=
		      new ArrayList<MultipartFile>();
   // 여러개 데이터 : List / String[]
   
}
