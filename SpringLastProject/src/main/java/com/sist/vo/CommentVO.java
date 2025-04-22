package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data
public class CommentVO {
   private int no,cno,type,group_id,group_step;
   private String userid,username,sex,msg,dbday;
   private Date regdate;
}
