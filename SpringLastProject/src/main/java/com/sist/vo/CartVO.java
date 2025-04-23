package com.sist.vo;
/*
 *   CNO     NOT NULL NUMBER       
GNO              NUMBER       
USERID           VARCHAR2(20) 
ACCOUNT          NUMBER       
ISBUY            NUMBER       
REGDATE          DATE         

 */
import java.util.*;

import lombok.Data;
@Data
public class CartVO {
  private int cno,gno,account,isbuy;
  private String userid,dbday;
  private Date regdate;
}
