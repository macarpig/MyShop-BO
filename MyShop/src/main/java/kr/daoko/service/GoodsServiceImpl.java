package kr.daoko.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.dao.GoodsDAO;
import kr.daoko.dto.GoodsDTO;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Inject
	private GoodsDAO dao;

	//상품 관리 목록 
	@Override
	public List<GoodsDTO> goodsManage() throws Exception {
		return dao.goodsManage();
	}
	
	@Override
	//상품 조회
	public GoodsDTO goodsView(String gdsCode) throws Exception {
		return dao.goodsView(gdsCode);
	}
	
	// 상품 추가
	@Override
	public void addProduct(GoodsDTO dto) throws Exception {
		dao.addProduct(dto);
	}
	
	@Override
	//상품 수정
		public void modifyGoods(GoodsDTO dto) throws Exception {
		dao.modifyGoods(dto);
	}
}
