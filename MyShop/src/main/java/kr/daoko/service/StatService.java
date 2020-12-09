package kr.daoko.service;

import java.util.List;

import kr.daoko.dto.QnaDTO;
import kr.daoko.dto.StatDTO;

public interface StatService {
	// 매출 목록 조회
	public List<StatDTO> listStat(StatDTO stat) throws Exception;
}
