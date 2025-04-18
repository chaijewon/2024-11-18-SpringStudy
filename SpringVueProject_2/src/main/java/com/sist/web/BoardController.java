package com.sist.web;
/*
     CREATE TABLE vueBoard(
   no NUMBER,
   name VARCHAR2(50) CONSTRAINT vue_name_nn NOT NULL,
   subject VARCHAR2(2000) CONSTRAINT vue_sub_nn NOT NULL,
   content CLOB CONSTRAINT vue_cont_nn NOT NULL,
   pwd VARCHAR2(10) CONSTRAINT vue_pwd_nn NOT NULL,
   regdate DATE DEFAULT SYSDATE,
   hit NUMBER DEFAULT 0,
   CONSTRAINT vue_no_pk PRIMARY KEY(no)
);
CREATE SEQUENCE vue_no_seq
      START WITH 1
      INCREMENT BY 1
      NOCACHE
      NOCYCLE;
INSERT INTO vueBoard VALUES(vue_no_seq.nextval,'홍길동',
'게시판 만들기','게시판 만들기','1234',SYSDATE,0);
COMMIT;  
 */
public class BoardController {

}
