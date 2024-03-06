package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.pagination.Criteria;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

	boolean insertBoard(@Param("board")BoardVO board);

	ArrayList<CommunityVO> selectCommunityList();

	BoardVO selectBoard(@Param("num") int num);

	void insertFile(@Param("file")FileVO fileVo);

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectTotalCount(@Param("cri")Criteria cri);

	boolean updateView(@Param("num")int num);

	boolean deleteBoard(@Param("num")int num);

	boolean updateBoard(@Param("board")BoardVO board);

	ArrayList<FileVO> selectFileList(@Param("bo_num")int num);

}
