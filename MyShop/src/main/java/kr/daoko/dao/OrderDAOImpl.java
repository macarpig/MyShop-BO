package kr.daoko.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {
	@Inject
	private SqlSession sql;
	
	// mapper
	private static String NAMESPACE = "kr.daoko.mapper.orderMapper";

	@Override
	public List<OrderDTO> orderInquiry() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(NAMESPACE + ".orderInquiry");
	}
	
}
