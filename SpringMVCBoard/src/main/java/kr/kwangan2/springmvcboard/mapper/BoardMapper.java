package kr.kwangan2.springmvcboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.kwangan2.springmvcboard.domain.BoardVO;

public interface BoardMapper {

	// @Select(" select * from board where bno > 0 ")
	public List<BoardVO> boardVOList();

	public void insertBoardVO(BoardVO boardVO);

	public void insertBoardVOSelectKey(BoardVO boardVO);

	public BoardVO selectBoardVO(Long bno);
	
	public int deleteBoardVO(Long bno);

	public int updateBoardVO(BoardVO boardVO);
	
	
	
}
