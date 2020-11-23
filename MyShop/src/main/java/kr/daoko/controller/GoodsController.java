package kr.daoko.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.daoko.dto.GoodsDTO;
import kr.daoko.dto.GoodsMemberDTO;
import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderStatusDTO;
import kr.daoko.service.GoodsService;
import kr.daoko.service.MemberService;
import kr.daoko.util.UploadFileUtils;

@Controller
@RequestMapping("/goods/*")
public class GoodsController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	GoodsService g_service;
	MemberService m_service;
	
	// 상품 업로드 패스
	@Resource(name="uploadPath")
	private String uploadPath;

	// 모든 상품 조회
	@GetMapping("/manage")
	public String getManage() {
		logger.info("getGoodsManage()");
		return "goods/manage";
	}

	// 상품 등록 창
	@GetMapping("/addwindow")
	public String getAddWindow(Model model) throws Exception {
		logger.info("getGoodsaddWindow()");
		return "goods/add";
	}

	// 상품 등록 처
	@PostMapping("/addwindow")
	public String postGoodsAdd(GoodsDTO dto, MultipartFile file) throws Exception {
		logger.info("postGoodsAdd()");
		//원본파일과 썸네일을 저장 후 db에 전하기 위해 입
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		//날짜 계산 
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		dto.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);

		g_service.addProduct(dto);
		return "redirect:/goods/manage";
	}

	// 상품 수정
	@GetMapping("/modify")
	public String getGoodsModify(@RequestParam("gdsCode") String gdsCode, Model model) throws Exception {
		logger.info("getGoodsModify()");

		GoodsDTO goods = g_service.goodsView(gdsCode);
		model.addAttribute("goods", goods);

		return "goods/modify";
	}

	// 상품 수 처리
	@PostMapping("/modify")
	public String postGoodsModify(GoodsDTO dto, MultipartFile file, HttpServletRequest req) throws Exception {
		logger.info("postGoodsModify()");
		//새로운 파일이 등록되었는지 확인 
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			new File(uploadPath + req.getParameter("gdsImg")).delete();
			new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
			
			//새로 첨부한 파일 등록
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			dto.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		} else { //새로운 파일 등록되지 않으면 기존 이미지 그대
			dto.setGdsImg(req.getParameter("gdsImg"));
			dto.setGdsThumbImg(req.getParameter("gdsThumbImg"));
		}
		g_service.modifyGoods(dto);

		return "redirect:/goods/manage";
	}

	// 상품 삭제
	@PostMapping("/deletewindow")
	public String getDeleteGoods(@RequestParam("gdsCode") String gdsCode, Model model) throws Exception {
		logger.info("postDeleteGoods()");

		g_service.deleteGoods(gdsCode);

		return "redirect:/goods/manage";
	}
	
	// 상품 상세정보 출력
		@RequestMapping(value = "/detail", method = RequestMethod.GET)
		public String getGoodsDetail(@RequestParam("gdsCode") String gdsCode, Model model) throws Exception {
			logger.info("getGoodsDetail()");

			GoodsDTO goods = g_service.goodsView(gdsCode);
			
			model.addAttribute("member", goods);
			
			return "goods/detail";
		}

}
