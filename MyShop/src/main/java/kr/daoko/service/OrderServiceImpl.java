package kr.daoko.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.dao.OrderDAO;
import kr.daoko.dto.OrderDTO;
import kr.daoko.dto.OrderDetailDTO;
import kr.daoko.dto.OrderStatusDTO;

@Service
public class OrderServiceImpl implements OrderService {
	@Inject
	private OrderDAO dao;

	// 주문 조회
	@Override
	public List<OrderDTO> orderInquiry() throws Exception {
		return dao.orderInquiry();
	}

	@Override
	public List<OrderDetailDTO> orderDetail(String orderId) throws Exception {
		return dao.orderDetail(orderId);
	}

	@Override
	public OrderDTO orderInfo(String orderId) throws Exception {
		return dao.orderInfo(orderId);
	}

	@Override
	public OrderStatusDTO orderStates() throws Exception {
		return dao.orderStates();
	}
	
	// 특정 사용자에 대한 주문접수, 주문처리, 교환접수, 반품접수, 취소접수
	@Override
	public OrderStatusDTO orderStates(String userId) throws Exception {
		return dao.orderStates(userId);
	}

	// 특정 사용자 주문 조회
	@Override
	public List<OrderDTO> listOrderUser(String userId) throws Exception {
		return dao.listOrderUser(userId);
	}
	
	@Override
	public List<OrderDTO> orderProcess(String status) throws Exception {
		return dao.orderProcess(status);
	}

	@Override
	public void orderProcessEdit(HashMap<String, String> orderInfo) throws Exception {
		dao.orderProcessEdit(orderInfo);
	}

	@Override
	public List<OrderDTO> orderManage() throws Exception {
		return dao.orderManage();
	}
}
