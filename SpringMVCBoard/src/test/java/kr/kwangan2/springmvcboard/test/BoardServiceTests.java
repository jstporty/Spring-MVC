package kr.kwangan2.springmvcboard.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;

	@Test
	public void testExist() {
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + service);
		assertNotNull(service);
	}

	@Test
	public void testInsertBoardVO() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("service글 제목 ㅋ");
		boardVO.setContent(" service글 내용 ㅋ");
		boardVO.setWriter("service글 쓴사람 ㅋ");

		service.insertBoardVO(boardVO);
		log.info("생성된 게시물 번호 :" + boardVO.getBno());
	}

	
	@Test
	public void testBoardVOList() {
		service.boardVOList().forEach(board -> log.info(board));
	}

	@Test
	public void testSelectVOList() {
		log.info(service.selectBoardVO(10L));
	}
	
	@Test
	public void testDeleteVOList() {
		log.info(service.deleteBoardVO(10L));
	}
	
	@Test
	public void testUpdateVOList() {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setBno(4L);
		boardVO.setTitle("zzzz");
		boardVO.setContent(" zzzzzz");
		boardVO.setWriter("zzzz");
		log.info(service.updateBoardVO(boardVO));
	}

}
