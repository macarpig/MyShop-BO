package kr.daoko.dao;

import java.util.List;

import kr.daoko.dto.MemberDTO;

public interface MemberDAO {
	// 회원 목록 조회
	public List<MemberDTO> listMember() throws Exception;
	
	// 회원 정보 조회
	public MemberDTO viewMember(String userId) throws Exception;
	
	// 회원 정보 수정
	public void modifyMember(MemberDTO dto) throws Exception;
	
	// 회원 정보 삭제
	public void deleteMember(String userId) throws Exception;
}
