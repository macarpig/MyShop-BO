package kr.daoko.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.daoko.dto.GoodsMemberDTO;
import kr.daoko.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sql;
	
	// mapper
	private static String NAMESPACE = "kr.daoko.mapper.memberMapper";

	// 회원 목록 조회
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

	// 회원 정보 삭제
	@Override
	public void deleteMember(String userId) throws Exception {
		sql.delete(NAMESPACE + ".deletemember", userId);
	}
	
	//특정 상품을 구매한 회원 조회
	@Override
	public List<GoodsMemberDTO> goodsMember(String gdsCode) throws Exception {
		return sql.selectList(NAMESPACE + ".goodsmember", gdsCode);
	}
	
	@Override
	public int memberCount() throws Exception {
		return sql.selectOne(NAMESPACE + ".memberCount");
	}

	// 로그인 처리
	@Override
	public MemberDTO login(MemberDTO dto) throws Exception {
		return sql.selectOne(NAMESPACE + ".login", dto);
	}
}
