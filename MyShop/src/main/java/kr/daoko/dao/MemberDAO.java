package kr.daoko.dao;

import java.util.List;

import kr.daoko.dto.MemberDTO;

public interface MemberDAO {
	// È¸¿ø Á¶È¸
	public List<MemberDTO> listMember() throws Exception;
	
<<<<<<< HEAD
	// íšŒì› ì •ë³´ ì¡°íšŒ
	public MemberDTO viewMember(String userId) throws Exception;
	
	// íšŒì› ì •ë³´ ìˆ˜ì •
	public void modifyMember(MemberDTO dto) throws Exception;
=======
	// ID¿¡ ÀÇÇÑ ÁÖ¹®¿¡ ´ëÇÑ Á¤º¸ Á¶È¸
	public MemberDTO memberInfo(String userId) throws Exception;
>>>>>>> branch 'master' of https://github.com/macarpig/MyShop-BO
}
