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

	@Override
	public MemberDTO memberInfo(String userId) throws Exception {
		return dao.memberInfo(userId);
	}
}
