package com.sist.vo;
/*
 *  NO        NOT NULL NUMBER         
	NAME      NOT NULL VARCHAR2(51)   
	SUBJECT   NOT NULL VARCHAR2(2000) 
	CONTENT   NOT NULL CLOB           
	PWD       NOT NULL VARCHAR2(10)   
	REGDATE            DATE           
	HIT                NUMBER         
	FILENAME           VARCHAR2(2000) 
	FILESIZE           VARCHAR2(1000) 
	FILECOUNT          NUMBER         

 */
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

// String a,b,c,d   SELECT name as a,subject,content,pwd 
@Data
public class DataBoardVO {
   private int no,hit,filecount,replycount;
   private String name,subject,content,pwd,filename,filesize,dbday;
   private Date regdate;
   // upload 
   private List<MultipartFile> files;//files[0]...
}
