package kr.daoko.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.daoko.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sql;
	
	// mapper
	private static String NAMESPACE = "kr.daoko.mapper.memberMapper";

	// 회원 목록
	@Override
	public List<MemberDTO> listMember() throws Exception {
		return sql.selectList(NAMESPACE + ".listmember");
	}

	// 회원 정보 조회
	@Override
	public MemberDTO viewMember(String userId) throws Exception {
		return sql.selectOne(NAMESPACE + ".viewmember", userId);
	}

	// 회원 정보 수정
	@Override
	public void modifyMember(MemberDTO dto) throws Exception {
		sql.update(NAMESPACE + ".modifymember", dto);
	}
}
