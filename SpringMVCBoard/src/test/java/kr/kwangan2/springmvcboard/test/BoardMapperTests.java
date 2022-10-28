package kr.kwangan2.springmvcboard.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

//	@Test
//	public void testBoardVOList() {
//		mapper.boardVOList().forEach(board -> log.info(board));
//	}
//
//	@Test
//	public void testInsert() {
//
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성한은 글");
//		board.setContent("새로 작성한은 글 내용1");
//		board.setWriter("newbie");
//
//		mapper.insertBoardVO(board);
//
//		log.info(board);
//	}
//
//	@Test
//	public void testInsertSelectkey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성한은 글 key");
//		board.setContent("새로 작성한은 글 내용 key");
//		board.setWriter("newbie key");
//
//		mapper.insertBoardVOSelectKey(board);
//		
//		log.info(board);
//	}
	
	@Test
	public void testSelectBoardVO() {
		BoardVO boarVO=mapper.selectBoardVO(2L);
		log.info(boarVO);
	}
	
	@Test
	public void testDeleteBoardVO() {
		int result= mapper.deleteBoardVO(7L);
		log.info("delete"+result);
	}

	@Test
	public void testUpdateBoardVO() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(6);
		boardVO.setTitle("수정된 제목");
		boardVO.setContent("수정된 내용 ");
		boardVO.setWriter("수정된 작성자");
		int result = mapper.updateBoardVO(boardVO);
		
		log.info("update--------------"+result);
	}
	
	
	
}//class
