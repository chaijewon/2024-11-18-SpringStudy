package com.sist.vo;
/*
 *   NO         NOT NULL NUMBER       
	BNO                 NUMBER       
	ID                  VARCHAR2(20) 
	NAME       NOT NULL VARCHAR2(50) 
	MSG        NOT NULL CLOB         
	REGDATE             DATE         
	GROUP_ID            NUMBER       
	GROUP_STEP          NUMBER       
	GROUP_TAB           NUMBER       
	ROOT                NUMBER       
	DEPTH               NUMBER     
 */
import java.util.*;

import lombok.Data;
@Data
public class ReplyVO {
   private int no,bno,group_id,group_step,group_tab,root,depth;
   private String id,name,msg,dbday;
   private Date regdate;
}
