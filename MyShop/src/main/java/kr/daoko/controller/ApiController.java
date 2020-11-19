package kr.daoko.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.daoko.dto.GoodsDTO;
import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderDTO;
import kr.daoko.dto.OrderDetailDTO;
import kr.daoko.dto.QnaDTO;
import kr.daoko.service.GoodsService;
import kr.daoko.service.MemberService;
import kr.daoko.service.OrderService;
import kr.daoko.service.QnaService;

@Controller
@RequestMapping("/api/*")
public class ApiController {
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Inject
	private MemberService memberService;
	
	@Inject
	private OrderService orderService;
	
	@Inject
	private GoodsService goodsService;
	
	@Inject
	private QnaService qnaService;
	
	Gson gson = new Gson();
	
	// 회원 목록
	@ResponseBody
	@RequestMapping(value = "/member/list", produces = "application/json", method = RequestMethod.GET)
	public String getMemberList() throws Exception {
		logger.info("from ApiController: getMemberList()");
		
		List<MemberDTO> list = memberService.listMember();
		String json = gson.toJson(list);
		
		return json;
	}
	
	//상품 목록 조회
	@ResponseBody
	@RequestMapping(value = "goods/manage", produces = "application/json", method = RequestMethod.GET)
	public String getGoodsList() throws Exception {
		logger.info("from ApiController: getMemberList()");
		
		List<GoodsDTO> list = goodsService.goodsManage();
		String json = gson.toJson(list);
		
		return json;
	}
	
	// 특정 사용자 Q&A 목록
	@ResponseBody
	@RequestMapping(value = "/qna/list", produces = "application/json", method = RequestMethod.GET)
	public String getListQna(@RequestParam("userId") String userId) throws Exception {
		logger.info("from ApiController: getListQna(String userId)");

		List<QnaDTO> qna = qnaService.listQna(userId);
		String json = gson.toJson(qna);

		return json;
	}
		
	//주문 조회
	@ResponseBody
	@RequestMapping(value = "/order/inquiry", produces = "application/json", method = RequestMethod.GET)
	public String getOrderInquiry() throws Exception {
		logger.info("from ApiController: getOderInquiry()");
		
		List<OrderDTO> order = orderService.orderInquiry();
		String json = gson.toJson(order);
		
		return json;
	}
	
	// 특정 사용자 주문 목록
	@ResponseBody
	@RequestMapping(value = "/order/list", produces = "application/json", method = RequestMethod.GET)
	public String getGoodsList(@RequestParam("userId") String userId) throws Exception {
		logger.info("from ApiController: getGoodsList(String userId)");
		
		List<OrderDTO> order = orderService.listOrderUser(userId);
		String json = gson.toJson(order);
		
		return json;
	}
	
	//orderId에 대한 orderDetail
		@ResponseBody
		   @RequestMapping(value = "/order/detail", produces = "application/json", method = RequestMethod.GET)
		   public String getOrderDetail(@RequestParam String orderId) throws Exception {
		      logger.info("from ApiController: getOderDetail()");
		      List<OrderDetailDTO> order = orderService.orderDetail(orderId);

		      String json = gson.toJson(order);
		      
		      return json;
		}
		
		//상태에 따른 주문 조회
		@ResponseBody
		@RequestMapping(value = "/order/process", produces = "application/json", method = RequestMethod.GET)
		public String getOrderProcess(@RequestParam int page) throws Exception {
			logger.info("from ApiController: getOderProcess()");
			
			String status = null;
			if(page == 0)
				status="결제완료";
			else if(page == 1)
				status="배송준비";
			else if(page == 2)
				status="교환접수";
			else if(page == 3)
				status="환불접수";
			else if(page == 4)
				status="취소접수";
			
			List<OrderDTO> order = orderService.orderProcess(status);
			
			String json = gson.toJson(order);
			
			return json;
		}
}
