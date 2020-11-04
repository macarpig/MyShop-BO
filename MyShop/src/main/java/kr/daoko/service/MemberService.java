package kr.daoko.service;

import java.util.List;

import kr.daoko.dto.MemberDTO;

public interface MemberService {
	// 회원 목록
	public List<MemberDTO> listMember() throws Exception;
}
