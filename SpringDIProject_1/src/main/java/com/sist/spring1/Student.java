package com.sist.spring1;

public class Student {
    private int hakbun;
    private int kor,eng,math;
    private Human human=new Human();
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public Human getHuman() {
		return human;
	}
	public void setHuman(Human human) {
		this.human = human;
	}
	public void init() {
		System.out.println("학생 정보");
	}
    public void destory() {
    	System.out.println("프로그램 종료");
    }
}
