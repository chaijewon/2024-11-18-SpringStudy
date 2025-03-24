package com.sist.dao;

import lombok.Data;
// BasicDataSource
@Data
public class MyDataSource {
   private String driver;
   private String url,username,password;
}
