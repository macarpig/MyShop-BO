package kr.daoko.service;

import java.util.List;

import kr.daoko.dto.QnaDTO;

public interface QnaService {
	// Q&A 목록 조회
	public List<QnaDTO> listQna() throws Exception;
	
	// 특정 사용자 Q&A 목록 조회
	public List<QnaDTO> listQna(String userId) throws Exception;
	
	// Q&A 답변 조호
	public QnaDTO viewQna(int idx) throws Exception;
}
