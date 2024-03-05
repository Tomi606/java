package kr.kh.app.service;

import java.util.ArrayList;

import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList();

	boolean insertBoard(BoardVO board, ArrayList<Part> partList);

	ArrayList<CommunityVO> getCommunityList();

	BoardVO getBoard(int num);

}
