package kr.daoko.dao;

import java.util.List;

import kr.daoko.dto.QnaDTO;
import kr.daoko.dto.StatDTO;

public interface StatDAO {
	// 매출 목록 조회
	public List<StatDTO> listStat() throws Exception;
}
