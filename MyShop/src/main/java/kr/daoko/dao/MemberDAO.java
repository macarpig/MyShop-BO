package kr.daoko.dao;

import java.util.List;

import kr.daoko.dto.MemberDTO;

public interface MemberDAO {
	// ȸ�� ��ȸ
	public List<MemberDTO> listMember() throws Exception;
	
	// ID�� ���� �ֹ��� ���� ���� ��ȸ
	public MemberDTO memberInfo(String userId) throws Exception;
}
