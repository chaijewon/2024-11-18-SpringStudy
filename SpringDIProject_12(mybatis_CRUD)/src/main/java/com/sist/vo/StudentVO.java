package com.sist.vo;

import lombok.Data;

/*
 *      HAKBUN NOT NULL NUMBER       
		NAME   NOT NULL VARCHAR2(50) 
	    KOR             NUMBER       
	    ENG             NUMBER       
	    MATH            NUMBER 
 */
@Data
public class StudentVO {
   private int hakbun,kor,eng,math;
   private String name;
}
