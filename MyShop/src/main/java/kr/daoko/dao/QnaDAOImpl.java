package kr.daoko.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.daoko.dto.QnaDTO;

@Repository
public class QnaDAOImpl implements QnaDAO {
	@Inject
	private SqlSession sql;
	
	// mapper
	private static String NAMESPACE = "kr.daoko.mapper.qnaMapper";

	// Q&A 목록 조회
	@Override
	public List<QnaDTO> listQna() throws Exception {
		return sql.selectList(NAMESPACE + ".listqna");
	}

	// 특정 사용자 Q&A 목록 조회
	@Override
	public List<QnaDTO> listQna(String userId) throws Exception {
		return sql.selectList(NAMESPACE + ".listqnauser", userId);
	}

	// Q&A 답변 조회
	@Override
	public QnaDTO viewQna(int idx) throws Exception {
		return sql.selectOne(NAMESPACE + ".viewqna", idx);
	}

	// Q&A 답변 처리
	@Override
	public void modifyQna(QnaDTO dto) throws Exception {
		sql.update(NAMESPACE + ".modifyqna", dto);
	}
}
