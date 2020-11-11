package kr.daoko.service;

import java.util.List;

import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderDTO;
import kr.daoko.dto.OrderDetailDTO;

public interface OrderService {
	// 주문 조회
	public List<OrderDTO> orderInquiry() throws Exception;
	
	// 주문 번호에 의한 상세 목록
	public List<OrderDetailDTO> orderDetail(String orderId) throws Exception;
	
	// 주문 번호에 의한 주문 정보
	public OrderDTO orderInfo(String orderId) throws Exception;
}
