package com.sist.vo;

import lombok.Data;

@Data
public class RecipeVO {
	private int no,hit,likecount,replycount;
	private String title,poster,chef;
}
