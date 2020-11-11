package kr.daoko.service;

import java.util.List;

import kr.daoko.dto.MemberDTO;

public interface MemberService {
	// 회원 목록
	public List<MemberDTO> listMember() throws Exception;
	
<<<<<<< HEAD
	// 회원 정보 조회
	public MemberDTO viewMember(String userId) throws Exception;
	
	// 회원 정보 수정
	public void modifyMember(MemberDTO dto) throws Exception;
=======
	// ID에 의한 회원 정보
	public MemberDTO memberInfo(String userId) throws Exception;
>>>>>>> branch 'master' of https://github.com/macarpig/MyShop-BO
}
