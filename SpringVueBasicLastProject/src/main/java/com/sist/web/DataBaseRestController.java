package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
// => Vue / React => Spring-Boot
// yml 
@RestController
public class DataBaseRestController {
   @Autowired
   private DataBoardDAO dao;
   
   @GetMapping(value = "databoard/list_vue.do")
   public Map databoardListData(int page)
   //throws Exception
   {
	   Map map=new HashMap();
	   map.put("start", (page*10)-9);
	   map.put("end", page*10);
	   
	   List<DataBoardVO> list=dao.databoardListData(map);
	   int totalpage=dao.databoardTotalPage();
	   
	   // JSP로 값을 전송 
	   map=new HashMap();
	   map.put("list", list);
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   
	   ///ObjectMapper mapper=new ObjectMapper();
	   ///String json=mapper.writeValueAsString(map);
	   return map;
	   
   }
   @PostMapping(value = "databoard/insert_ok.do",
		   produces = "text/plain;charset=UTF-8")
   public String databoardInsertOk(DataBoardVO vo,HttpServletRequest request)
   {
	   String path="c:\\upload";
	   //path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
	   String result="";
	   try
	   {
		   List<MultipartFile> list=vo.getFiles();
		   if(list==null)
		   {
			   vo.setFilename("");
			   vo.setFilesize("");
			   vo.setFilecount(0);
		   }
		   else
		   {
			   String filename="";
			   String filesize="";
			   for(MultipartFile mf:list)
			   {
				   String name=mf.getOriginalFilename();
				   File file=new File(path+"\\"+name);
				   mf.transferTo(file);
				   filename+=name+",";
				   filesize+=file.length()+",";
			   }
			   filename=filename.substring(0,filename.lastIndexOf(","));
			   filesize=filesize.substring(0,filesize.lastIndexOf(","));
			   vo.setFilename(filename);
			   vo.setFilesize(filesize);
			   vo.setFilecount(list.size());
		   }
		   result="yes";
		   dao.dataBoardInsert(vo);
	   }catch(Exception ex) 
	   {
		   result=ex.getMessage();   
	   }
	   return result;
   }
   @GetMapping("databoard/detail_vue.do")
   public DataBoardVO databoard_detail(int no)
   {
	   DataBoardVO vo=dao.databoardDetailData(no);
	   
	   return vo;
   }
   @GetMapping("databoard/download.do")
   public void databoard_download(String fn,HttpServletResponse response)
   {
	   try
	   {
		   String path="c:\\upload";
		   File file=new File(path+"\\"+fn);
		   response.setContentLength((int)file.length());
		   response.setHeader("Content-Disposition",
				   "attachment;filename="
				   +URLEncoder.encode(fn, "UTF-8"));
		   
		   // 복사 
		   BufferedInputStream bis=
				   new BufferedInputStream(
						   new FileInputStream(file));
		   BufferedOutputStream bos=
				   new BufferedOutputStream(
						   response.getOutputStream());
		   int i=0; // 읽은 바이트 수
		   byte[] buffer=new byte[1024];
		   while((i=bis.read(buffer, 0, 1024))!=-1)
		   {
			   bos.write(buffer, 0, i);
		   }
		   bis.close();
		   bos.close();
		   
	   }catch(Exception ex){}
   }
}
