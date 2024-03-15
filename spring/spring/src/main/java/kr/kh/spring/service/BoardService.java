package kr.kh.spring.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;

public interface BoardService {

	ArrayList<BoardVO> selectBoardList(Criteria cri);

	int getBoardTotalCount(Criteria cri);

	ArrayList<CommunityVO> getCommunityList();

	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] file);

}
