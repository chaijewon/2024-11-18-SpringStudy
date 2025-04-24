package com.sist.manager;
import java.net.URLEncoder;
import java.util.*;

import org.springframework.stereotype.Component;

import com.sist.vo.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
@Component
public class YoutubeManager {
   public static void main(String[] args) {
	   YoutubeManager y=new YoutubeManager();
	   y.youtubeJsonData("부산여행");
   }
   public String youtubeJsonData(String fd)
   {
	   String result="";
	   try
	   {
		   String strUrl="https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=25&q="+URLEncoder.encode(fd, "UTF-8")+"&type=video&key=";
	       URL url=new URL(strUrl);
	       HttpURLConnection conn=
	    		     (HttpURLConnection)url.openConnection();
	       // Jsoup.connection()
	       StringBuffer sb=new StringBuffer();
	       if(conn!=null) // 연결된 경우
	       {
	    	   BufferedReader in=
	    			 new BufferedReader(
	    					 new InputStreamReader(conn.getInputStream()));
	    	   while(true)
	    	   {
	    		   String s=in.readLine();
	    		   if(s==null)
	    			   break;
	    		   sb.append(s);
	    	   }
	    	   
	    	   result=sb.toString();
	    	   System.out.println(result);
	    	   in.close();
	    	   conn.disconnect();
	       }
	       System.out.println(sb.toString());
	   }catch(Exception ex){}
	   return result;
   }
}
