package kr.daoko.dao;

import java.util.List;

import kr.daoko.dto.MemberDTO;

public interface MemberDAO {
	// ȸ�� ��ȸ
	public List<MemberDTO> listMember() throws Exception;
	
<<<<<<< HEAD
	// 회원 정보 조회
	public MemberDTO viewMember(String userId) throws Exception;
	
	// 회원 정보 수정
	public void modifyMember(MemberDTO dto) throws Exception;
=======
	// ID�� ���� �ֹ��� ���� ���� ��ȸ
	public MemberDTO memberInfo(String userId) throws Exception;
>>>>>>> branch 'master' of https://github.com/macarpig/MyShop-BO
}
