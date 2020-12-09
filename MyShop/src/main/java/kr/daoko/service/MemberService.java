package kr.daoko.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.daoko.dto.GoodsMemberDTO;
import kr.daoko.dto.MemberDTO;

public interface MemberService {
	// 회원 목록
	public List<MemberDTO> listMember() throws Exception;
	
	// 회원 정보 조회
	public MemberDTO viewMember(String userId) throws Exception;
	
	// 회원 정보 수정
	public void modifyMember(MemberDTO dto) throws Exception;
	
	// 회원 정보 삭제
	public void deleteMember(String userId) throws Exception;
	
	// 특정 상품을 구매한 회원정보 조회
	public List<GoodsMemberDTO> goodsMember(String gdsCode) throws Exception;
	
	public int memberCount() throws Exception;
	
	// 로그인 처리
	public MemberDTO login(MemberDTO dto) throws Exception;
	
	// 로그아웃 처리
	public void logout(HttpSession session) throws Exception;
}
