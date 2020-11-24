package kr.daoko.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
	
	// 특정 사용자에 대한 주문접수, 주문처리, 교환접수, 반품접수, 취소접수
	@Override
	public OrderStatusDTO orderStates(String userId) throws Exception {
		return sql.selectOne(NAMESPACE + ".userorderstatus", userId);
	}

	// 특정 사용자 주문 조회
	@Override
	public List<OrderDTO> listOrderUser(String userId) throws Exception {
		return sql.selectList(NAMESPACE + ".listorderuser", userId);
	}
	
	@Override
	public List<OrderDTO> orderProcess(String status) throws Exception {
		return sql.selectList(NAMESPACE + ".orderProcess", status);
	}

	@Override
	public void orderProcessEdit(HashMap<String, String> orderInfo) throws Exception {
		sql.update(NAMESPACE+".orderProcessEdit", orderInfo);
	}

	@Override
	public List<OrderDTO> orderManage() throws Exception {
		return sql.selectList(NAMESPACE + ".orderManage");
	}

	@Override
	public void orderExOfficio(HashMap<String, String> ExOfficio) throws Exception {
		sql.update(NAMESPACE + ".orderExOfficio", ExOfficio);
	}
}
