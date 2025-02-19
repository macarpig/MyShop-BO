package kr.daoko.dao;

import java.util.HashMap;
import java.util.List;

import kr.daoko.dto.OrderDTO;
import kr.daoko.dto.OrderDetailDTO;
import kr.daoko.dto.OrderStatusDTO;

public interface OrderDAO {
	// 二쇰Ц 議고쉶
	public List<OrderDTO> orderInquiry() throws Exception;
	
	// 특정 사용자 주문 조회
	public List<OrderDTO> listOrderUser(String userId) throws Exception;
	
	// 二쇰Ц 踰덊샇�뿉 �쓽�븳 �긽�꽭 紐⑸줉
	public List<OrderDetailDTO> orderDetail(String orderId) throws Exception;
	
	// 二쇰Ц 踰덊샇�뿉 �쓽�븳 二쇰Ц �젙蹂�
	public OrderDTO orderInfo(String orderId) throws Exception;
	
	// 주문접수, 주문처리, 교환접수, 반품접수, 취소접수
	public OrderStatusDTO orderStates() throws Exception;
	
	// 특정 사용자에 대한 주문접수, 주문처리, 교환접수, 반품접수, 취소접수
	public OrderStatusDTO orderStates(String userId) throws Exception;

	//상태에 따른 주문 처리 조회
	public List<OrderDTO> orderProcess(String status) throws Exception;
	
	//orderId에 대한 처리
	public void orderProcessEdit(HashMap<String, String> orderInfo) throws Exception;
	
	//주문 직권 처리 관리를 위한 조회
	public List<OrderDTO> orderManage0() throws Exception;
	
	//주문 직권 처리 관리를 위한 조회
	public List<OrderDTO> orderManage1() throws Exception;
	
	//사유 수정과 직권 처리 후
	public void orderExOfficio(HashMap<String, String> ExOfficio) throws Exception;
}
