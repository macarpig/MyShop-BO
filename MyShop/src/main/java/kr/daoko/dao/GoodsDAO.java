package kr.daoko.dao;

import java.util.List;

import kr.daoko.dto.GoodsDTO;

public interface GoodsDAO {
	// 상품 관리 목록
	public List<GoodsDTO> goodsManage() throws Exception;
	
	//상품 추가
	public void addProduct(GoodsDTO dto) throws Exception;
}
