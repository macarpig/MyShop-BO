package kr.daoko.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.dao.MemberDAO;
import kr.daoko.dao.OrderDAO;
import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {
	@Inject
	private OrderDAO dao;

	// 주문 조회
	@Override
	public List<OrderDTO> orderInquiry() throws Exception {
		return dao.orderInquiry();
	}
	
	
}
