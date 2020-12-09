package kr.daoko.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.server.header.StaticServerHttpHeadersWriter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.daoko.dto.GoodsDTO;
import kr.daoko.dto.GoodsMemberDTO;
import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderDTO;
import kr.daoko.dto.OrderDetailDTO;
import kr.daoko.dto.QnaDTO;
import kr.daoko.dto.StatChartDTO;
import kr.daoko.dto.StatDTO;
import kr.daoko.service.GoodsService;
import kr.daoko.service.MemberService;
import kr.daoko.service.OrderService;
import kr.daoko.service.QnaService;
import kr.daoko.service.StatService;

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
	
	@Inject
	private StatService statService;
	
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
	
	// 특정 상품주문 회원
	@ResponseBody
	@RequestMapping(value = "/member/goods", produces = "application/json", method = RequestMethod.GET)
	public String getMemberGoods(@RequestParam("userId") String userId) throws Exception {
		logger.info("gdtMemberGoods(String gdsCode)");

		List<GoodsMemberDTO> goods = memberService.goodsMember(userId);
		String json = gson.toJson(goods);

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
	
	// Q&A 목록
	@ResponseBody
	@RequestMapping(value = "/qna/list", produces = "application/json", method = RequestMethod.GET)
	public String getQnaList() throws Exception {
		logger.info("from ApiController: getQnaList()");

		List<QnaDTO> qna = qnaService.listQna();
		String json = gson.toJson(qna);
		
		return json;
	}
	
	// 특정 사용자 Q&A 목록
	@ResponseBody
	@RequestMapping(value = "/qna/listuser", produces = "application/json", method = RequestMethod.GET)
	public String getListQna(@RequestParam("userId") String userId) throws Exception {
		logger.info("from ApiController: getListQna(String userId)");

		List<QnaDTO> qna = qnaService.listQnaUser(userId);
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
			status="반품접수";
		else if(page == 4)
			status="취소접수";

		List<OrderDTO> order = orderService.orderProcess(status);

		String json = gson.toJson(order);

		return json;
	}
		
	//직권 처리를 위한 주문 조회
	@ResponseBody
	@RequestMapping(value = "/order/manage", produces = "application/json", method = RequestMethod.GET)
	public String getOrderManage(@RequestParam int page) throws Exception {
		logger.info("from ApiController: getOderManage()");
		
		List<OrderDTO> order = null;
		if(page ==0) {
			order = orderService.orderManage0();
		}else if(page ==1) {
			order = orderService.orderManage1();
		}
		
		String json = gson.toJson(order);
		return json;
	}
	
	// 회원 목록
    @ResponseBody
    @RequestMapping(value = "/member/purchaser", produces = "application/json", method = RequestMethod.GET)
    public String getMemberPurchaser(@RequestParam String gdsCode) throws Exception {
       logger.info("from ApiController: getMemberPurchaser()");
       
       List<GoodsMemberDTO> list = memberService.goodsMember(gdsCode);
       String json = gson.toJson(list);
       
       return json;
    }

    // 회원 목록
    @ResponseBody
    @RequestMapping(value = "/stat/manage", produces = "application/json", method = RequestMethod.GET)
    public String getStatManage(@RequestParam(required = false) String gdsCode, @RequestParam(required = false) String cateName, @RequestParam(required = false) String gdsName, @RequestParam(required = false) String userId, @RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate) throws Exception {
       logger.info("from ApiController: getStatManage()");
       
       StatDTO stat = new StatDTO();
       stat.setGdsCode(gdsCode);
       stat.setCateName(cateName);
       stat.setGdsName(gdsName);
       stat.setUserId(userId);
       stat.setStartDate(startDate);
       stat.setEndDate(endDate);

       List<StatDTO> list = statService.listStat(stat);
       String json = gson.toJson(list);
       
       return json;
    }
    
    @ResponseBody
    @RequestMapping(value = "/stat/manageChart", produces = "application/json", method = RequestMethod.GET)
    public String getStatManageChart(@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate) throws Exception {
    	logger.info("from ApiController: getStatManageChart()");
    	
    	StatDTO stat = new StatDTO();
        stat.setStartDate(startDate);
        stat.setEndDate(endDate);
        
        List<StatChartDTO> list = statService.statChart(stat);
    	String json = gson.toJson(list);
        return json;
    }
}
