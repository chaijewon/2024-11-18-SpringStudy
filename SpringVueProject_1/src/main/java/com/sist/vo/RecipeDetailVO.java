package com.sist.vo;

import lombok.Data;

@Data
public class RecipeDetailVO {
	private int no,likecount;
	private String poster,title,chef,chef_poster,
	        chef_profile,info1,info2,info3,content
	        ,foodmake,data;
}
