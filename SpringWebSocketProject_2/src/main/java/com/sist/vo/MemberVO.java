package com.sist.vo;

import javax.websocket.Session;

import lombok.Data;

@Data
public class MemberVO {
  private String id,pwd,name,sex,msg;
  private Session session;
}
