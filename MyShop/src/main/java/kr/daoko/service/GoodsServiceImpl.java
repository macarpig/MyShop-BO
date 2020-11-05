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
	
	
}
