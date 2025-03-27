package com.sist.manager;

import org.snu.ids.ha.index.Keyword;
import org.snu.ids.ha.index.KeywordExtractor;
import org.snu.ids.ha.index.KeywordList;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.vo.*;
@Component
public class WordManager {
	public List<WordVO> wordListData(String content)
	   {
		   List<WordVO> list=new ArrayList<WordVO>();
		   // string to extract keywords
		   String strToExtrtKwrd = content;

		   // init KeywordExtractor
		   KeywordExtractor ke = new KeywordExtractor();

		   // extract keywords
		   KeywordList kl = ke.extractKeyword(strToExtrtKwrd, true);

		   // print result
		   for( int i = 0; i < kl.size(); i++ ) {
		   	Keyword kwrd = kl.get(i);
		   	System.out.println(kwrd.getString() + "\t" + kwrd.getCnt());
		   	if(kwrd.getString().length()>1 && kwrd.getCnt()>=1)
		   	{
		   		WordVO vo=new WordVO();
		   		vo.setCount(kwrd.getCnt());
		   		vo.setWord(kwrd.getString());
		   		list.add(vo);
		   	}
		   	
		   }
		   return list;
	   }
}
