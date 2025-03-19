package com.sist.sawon;

import org.springframework.stereotype.Component;
@Component
public class Sawon {
    private int sabun=1;
    private String name="ȫ�浿";
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
   
}
