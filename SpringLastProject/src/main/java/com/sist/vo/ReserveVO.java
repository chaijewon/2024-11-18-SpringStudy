package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data
public class ReserveVO {
  private int rno,isreserve;
  private String userid,rday,rtime,rinwon;
  private Date regdate;
  private FoodVO fvo=new FoodVO();
  private MemberVO mvo=new MemberVO();
}
