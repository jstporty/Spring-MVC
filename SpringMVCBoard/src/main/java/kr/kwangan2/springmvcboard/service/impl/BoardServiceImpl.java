package kr.kwangan2.springmvcboard.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

public class BoardServiceImpl extends AbstractBoardService {
	
	@Override
	public List<BoardVO> boardVOList() {
		return null;
	}

	@Override
	public void insertBoardVO(BoardVO boardVO) {

	}

	@Override
	public void insertBoardVOSelectKey(BoardVO boardVO) {

	}

	@Override
	public BoardVO selectBoardVO(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBoardVO(Long bno) {
		return 0;
	}

	@Override
	public int updateBoardVO(BoardVO boardVO) {
		return 0;
	}

}
