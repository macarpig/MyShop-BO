package kr.daoko.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderDTO;
import kr.daoko.dto.OrderDetailDTO;
import kr.daoko.dto.OrderStatusDTO;

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

	@Override
	public List<OrderDetailDTO> orderDetail(String orderId) throws Exception {
		return sql.selectList(NAMESPACE + ".orderDetail", orderId);
	}

	@Override
	public OrderDTO orderInfo(String orderId) throws Exception {
		return sql.selectOne(NAMESPACE + ".orderInfo", orderId);
	}

	@Override
	public OrderStatusDTO orderStates() throws Exception {
		return sql.selectOne(NAMESPACE + ".orderStates");
	}
	
}
