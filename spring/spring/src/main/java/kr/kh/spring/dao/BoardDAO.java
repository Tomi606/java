package kr.kh.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.pagination.Criteria;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList(@Param("cri") Criteria cri);

	int selectBoardTotalCount(@Param("cri") Criteria cri);

	ArrayList<CommunityVO> selectCommunityList();

	boolean insertBoard(@Param("bo") BoardVO board);

	void insertFile(@Param("fi") FileVO fileVo);

	BoardVO selectBoard(@Param("bo_num") int boNum);

	void updateView(@Param("bo_num") int boNum);

	ArrayList<FileVO> selectFileList(@Param("bo_num") int boNum);

	void deleteFile(@Param("fi_num") int fi_num);

	//int bo_num은 서비스와 별개로 이름을 지정해도 된다.
	boolean deleteBoard(@Param("bo_num")int bo_num);

	boolean updateBoard(@Param("board") BoardVO board);

	FileVO selectFile(@Param("fi_num") int tmp);

}
