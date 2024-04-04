package kr.kh.spring3.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring3.dao.BoardDAO;
import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	private BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			//전체 게시판 중에서 게시글을 가져오는 것이기 때문에 이렇게 작성
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getBoardTotalCount(Criteria cri) {
		return boardDao.selectBoardTotalCount(cri);
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user) {
		if(board == null 
		|| board.getBo_title() == null 
		|| board.getBo_content() == null) {
			return false;
		}
		
		if(user == null) {
			return false;
		}
		//게시글의 아이디를 (유저의 아이디를 가져와서) 수정한다.
		board.setBo_me_id(user.getMe_id());
		return boardDao.insertBoard(board);
	}

}
