package kr.kwangan2.springmvcboard.service.impl;

import java.util.List;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import kr.kwangan2.springmvcboard.service.BoardService;

public abstract class AbstractBoardService implements BoardService {

	@Override
	public List<BoardVO> boardVOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBoardVO(BoardVO boardVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertBoardVOSelectKey(BoardVO boardVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO selectBoardVO(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBoardVO(Long bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoardVO(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
