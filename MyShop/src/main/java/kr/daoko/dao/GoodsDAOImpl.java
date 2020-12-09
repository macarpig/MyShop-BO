package kr.daoko.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.daoko.dto.GoodsDTO;
import kr.daoko.dto.MemberDTO;

@Repository
public class GoodsDAOImpl implements GoodsDAO {
	@Inject
	private SqlSession sql;
	
	// mapper
	private static String NAMESPACE = "kr.daoko.mapper.goodsMapper";
	
	//상품리스트
	@Override
	public List<GoodsDTO> goodsManage() throws Exception {
		return sql.selectList(NAMESPACE + ".goodsManage");
	}
	
	//상품 조회
	public GoodsDTO goodsView(String gdsCode) throws Exception {
		return sql.selectOne(NAMESPACE + ".goodsView", gdsCode);
	}
	
	//상품 추가
	@Override
	public void addProduct(GoodsDTO dto) throws Exception {
		sql.insert(NAMESPACE + ".addProduct", dto);
	}
	
	@Override
	//상품 수정
	public void modifyGoods(GoodsDTO dto) throws Exception {
		sql.update(NAMESPACE + ".modifyGoods", dto);
	}
	
	@Override
	//상품 삭제
	public void deleteGoods(String gdsCode) throws Exception {
		sql.delete(NAMESPACE + ".deleteGoods", gdsCode);
	}
	
	@Override
	//상품 총 개수
	public int productCount() throws Exception {
		return sql.selectOne(NAMESPACE + ".productCount");
	}
	
}
