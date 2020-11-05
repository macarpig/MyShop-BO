package kr.daoko.service;

import java.util.List;

import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderDTO;

public interface OrderService {
	// 주문 조회
	public List<OrderDTO> orderInquiry() throws Exception;
}
