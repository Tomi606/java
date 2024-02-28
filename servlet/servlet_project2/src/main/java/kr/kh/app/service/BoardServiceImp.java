package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;

public class BoardServiceImp implements BoardService {

	private BoardDAO boardDao;
	
	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sessionFactory.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public boolean insertBoard(BoardVO board) {
		if(board == null
		|| !checkString(board.getBo_title())
		|| !checkString(board.getBo_content())) {
			return false;
		}
		return boardDao.insertBoard(board);
	}
	
	//문자열이 null이거나 빈 문자열이면 false, 아니면 true를 반환하는 메서드
	public boolean checkString(String str) {
		if(str == null || str.length() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunityList();
	}

	//num은 객체가 아니기 때문에 검색해서 없으면 바로 null로 처리되서 if문 돌릴 필요 X
	@Override
	public BoardVO getBoard(int num) {
		return boardDao.selectBoard(num);
	}

}
