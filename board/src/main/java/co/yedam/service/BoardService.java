package co.yedam.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardList(SearchVO search);
	List<BoardVO> boardList2();
	int getCount(SearchVO search); //전체 건수 가져오기
	
	BoardVO getBoard(int bno);
	boolean addBoard(BoardVO vo);
	boolean modifyBoard(BoardVO vo);
	boolean removeBoard(int bno);
	
	boolean addcnt(int bno);
}
