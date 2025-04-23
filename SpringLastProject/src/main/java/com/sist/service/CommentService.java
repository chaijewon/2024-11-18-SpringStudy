package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.CommentVO;

public interface CommentService {
	public List<CommentVO> commentListData(Map map);
	public int commentTotalPage(int cno,int type);
	public void commenInsert(CommentVO vo);
	public void commentUpdate(String msg,int no);
	public void commentReplyReplyInsert(int pno,CommentVO vo);
}
