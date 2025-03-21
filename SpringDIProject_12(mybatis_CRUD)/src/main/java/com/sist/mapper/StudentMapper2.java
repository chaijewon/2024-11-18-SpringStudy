package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.StudentVO;

public interface StudentMapper2 {
	@Select("SELECT * FROM student")
	public List<StudentVO> studentListData();
	
	public StudentVO studentDetailData(int hakbun);
	public void studentInsert(StudentVO vo);
	public void studentDelete(int hakbun);
	public void studentUpdate(StudentVO vo);
}
