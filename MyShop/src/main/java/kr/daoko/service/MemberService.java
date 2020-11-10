package kr.daoko.service;

import java.util.List;

import kr.daoko.dto.MemberDTO;

public interface MemberService {
	// 회원 목록
	public List<MemberDTO> listMember() throws Exception;
	
	// ID에 의한 회원 정보
	public MemberDTO memberInfo(String userId) throws Exception;
}
