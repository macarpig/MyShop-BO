package kr.daoko.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.dao.QnaDAO;
import kr.daoko.dto.QnaDTO;

@Service
public class QnaServiceImpl implements QnaService {
	@Inject
	private QnaDAO dao;

	// Q&A 목록 조회
	@Override
	public List<QnaDTO> listQna() throws Exception {
		return dao.listQna();
	}

	// 특정 사용자 Q&A 목록 조회
	@Override
	public List<QnaDTO> listQnaUser(String userId) throws Exception {
		return dao.listQnaUser(userId);
	}

	// Q&A 답변 조회
	@Override
	public QnaDTO viewQna(int idx) throws Exception {
		return dao.viewQna(idx);
	}

	// Q&A 답변 처리
	@Override
	public void modifyQna(QnaDTO dto) throws Exception {
		dao.modifyQna(dto);
	}
}
