package com.sist.auto;

import org.springframework.stereotype.Component;

@Component
public class MySQL implements DAO{

	@Override
	public void connection() {
		// TODO Auto-generated method stub
		System.out.println("MySQL 연결");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("MySQL 해제");
	}

}
