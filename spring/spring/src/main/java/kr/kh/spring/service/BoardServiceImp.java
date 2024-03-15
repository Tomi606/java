package kr.kh.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDAO boardDao;

	private boolean checkStrinig(String str) {
		return str != null && str.length() != 0;
	}
	
	@Override
	public ArrayList<BoardVO> selectBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria(1, 5);
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getBoardTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria(1, 5);
		}
		return boardDao.selectBoardTotalCount(cri);
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunityList();
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user) {
		if(user == null || board == null) {
			return false;
		}
		if(!checkStrinig(board.getBo_title())
		|| !checkStrinig(board.getBo_content())) {
			return false;
		}
		
		board.setBo_me_id(user.getMe_id());
		boolean res = boardDao.insertBoard(board);
		
		return res;
	}
}
