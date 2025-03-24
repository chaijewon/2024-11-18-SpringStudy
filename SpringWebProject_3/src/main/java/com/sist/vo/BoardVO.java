package com.sist.vo;
/*
 *  1. 동작 방법 / 사용법 
 *  2. 데이터베이스 연동 => 화면 
 *  ---------------------- 반복 
 */
import java.util.*;

import lombok.Data;
// 필수 => CRUD 
@Data
public class BoardVO {
  private int no,hit;
  private String name,subject,content,pwd,dbday;
  private Date regdate;
}
