package kr.daoko.dao;

import java.util.List;

import kr.daoko.dto.QnaDTO;

public interface QnaDAO {
	// Q&A 목록 조회
	public List<QnaDTO> listQna() throws Exception;
	
	// 특정 사용자 Q&A 목록 조회
	public List<QnaDTO> listQna(String userId) throws Exception;
}
