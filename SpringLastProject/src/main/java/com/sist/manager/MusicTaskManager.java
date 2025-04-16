package com.sist.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Component
public class MusicTaskManager {
   @Autowired
   private MusicDAO dao;
   //@Scheduled(fixedRate = 60*60*1000)
   public void musicSchedul() {
	  try
	  {
		  dao.musicDelete();
		  Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
		  Elements title=doc.select("table.list-wrap a.title");
		  Elements singer=doc.select("table.list-wrap a.artist");
		  for(int i=0;i<title.size();i++)
		  {
			  MusicVO vo=new MusicVO();
			  String t=title.get(i).text();
			  String s=singer.get(i).text();
			  vo.setTitle(t);
			  vo.setSinger(s);
			  dao.musicInsert(vo);
		  }
		  
	  }catch(Exception ex) {}
   }
}
