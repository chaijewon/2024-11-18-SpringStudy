package com.sist.vo;

import lombok.Data;

@Data
public class FoodVO {
	 private int fno,hit,jjimcount,likecount,replycount;
	 private double score;
	 private String name,type,theme,poster,images,time,
	        parking,content,price,address,phone;
}
