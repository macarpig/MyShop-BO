package kr.daoko.service;

import java.util.List;

import kr.daoko.dto.GoodsDTO;
import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderDTO;

public interface GoodsService {
	// 상품 관리
	public List<GoodsDTO> goodsManage() throws Exception;
	
	// 상품 추가
	public void addProduct(GoodsDTO dto) throws Exception;
}
