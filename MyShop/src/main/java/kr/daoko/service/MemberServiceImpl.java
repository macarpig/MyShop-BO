package kr.daoko.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.dao.MemberDAO;
import kr.daoko.dto.GoodsMemberDTO;
import kr.daoko.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO dao;
	
	// 회원 목록 조회
	@Override
	public List<MemberDTO> listMember() throws Exception {
		return dao.listMember();
	}

	// 회원 정보 조회
	@Override
	public MemberDTO viewMember(String userId) throws Exception {
		return dao.viewMember(userId);
	}

	// 회원 정보 수정
	@Override
	public void modifyMember(MemberDTO dto) throws Exception {
		dao.modifyMember(dto);
	}

	// 회원 정보 삭제
	@Override
	public void deleteMember(String userId) throws Exception {
		dao.deleteMember(userId);
	}
	
	// 특정 상품을 구매한 회원 조회
	@Override
	public List<GoodsMemberDTO> goodsMember(String gdsCode) throws Exception {
		return dao.goodsMember(gdsCode);
	}
}
