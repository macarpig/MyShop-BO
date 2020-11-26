package kr.daoko.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.daoko.dto.QnaDTO;
import kr.daoko.service.QnaService;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Inject
	private QnaService service;
	
	// Q&A 목록 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getQnaList() throws Exception {
		logger.info("from QnaController: getQnaList()");
		
		return "qna/list";
	}
	
	// Q&A 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String getQnaView(@RequestParam("idx") int idx, Model model) throws Exception {
		logger.info("from QnaController: getQnaView()");

		QnaDTO qna = service.viewQna(idx);
		model.addAttribute("qna", qna);
		
		return "qna/view";
	}
}
