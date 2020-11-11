package kr.daoko.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.dao.MemberDAO;
import kr.daoko.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO dao;
	
	// 회원 목록
	@Override
	public List<MemberDTO> listMember() throws Exception {
		return dao.listMember();
	}

<<<<<<< HEAD
	// 회원 정보 조회
	@Override
	public MemberDTO viewMember(String userId) throws Exception {
		return dao.viewMember(userId);
	}

	// 회원 정보 수정
	@Override
	public void modifyMember(MemberDTO dto) throws Exception {
		dao.modifyMember(dto);
=======
	@Override
	public MemberDTO memberInfo(String userId) throws Exception {
		return dao.memberInfo(userId);
>>>>>>> branch 'master' of https://github.com/macarpig/MyShop-BO
	}
}
