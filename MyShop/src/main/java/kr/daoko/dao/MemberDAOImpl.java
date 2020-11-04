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
}
