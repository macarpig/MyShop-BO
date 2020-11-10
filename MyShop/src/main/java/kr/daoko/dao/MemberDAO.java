package kr.daoko.dao;

import java.util.List;

import kr.daoko.dto.MemberDTO;

public interface MemberDAO {
	// 회원 조회
	public List<MemberDTO> listMember() throws Exception;
	
	// ID에 의한 주문에 대한 정보 조회
	public MemberDTO memberInfo(String userId) throws Exception;
}
