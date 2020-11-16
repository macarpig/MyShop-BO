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

	@Override
	public List<GoodsDTO> goodsManage() throws Exception {
		return sql.selectList(NAMESPACE + ".goodsManage");
	}
	
	@Override
	public void addProduct(GoodsDTO dto) throws Exception {
		sql.insert(NAMESPACE + ".addProduct", dto);
	}
}
