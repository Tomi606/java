package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO; //select mapper 만들때 복붙
import kr.kh.app.pagination.Criteria;

public interface BoardDAO {

	boolean insertBoard(@Param("board")BoardVO board);

	ArrayList<CommunityVO> selectCommunityList();

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectTotalCount(@Param("cri")Criteria cri);

}