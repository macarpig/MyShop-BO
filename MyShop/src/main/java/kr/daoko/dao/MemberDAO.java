package kr.daoko.dao;

import java.util.List;

import kr.daoko.dto.MemberDTO;

public interface MemberDAO {
	// 회원 목록
	public List<MemberDTO> listMember() throws Exception;
}
