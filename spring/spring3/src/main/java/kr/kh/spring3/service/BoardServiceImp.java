package kr.kh.spring3.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.UploadFileUtils.UploadFileUtils;
import kr.kh.spring3.dao.BoardDAO;
import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	private BoardDAO boardDao;

	@Resource
	String uploadPath;
	
	//파일 업로드 메서드
	private void uploadFile(int bo_num, MultipartFile file) {
		if(file == null || file.getOriginalFilename().length() == 0) 
			return;
		try {
			String fileOriName = file.getOriginalFilename();
			//첨부파일을 업로드하는 코드(UploadFileUtils.uploadFile)
			String fileName = UploadFileUtils.uploadFile(uploadPath, fileOriName, file.getBytes());
			//첨부파일을 DB에 저장할려는 FileVO 객체
			FileVO fileVo = new FileVO(bo_num, fileName, fileOriName);
			//DB에 첨부파일을 추가하는 코드
			boardDao.insertFile(fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
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
		boolean res =  boardDao.insertBoard(board);
		log.info(board);
		//게시글 등록 실패
		if(!res) {
			return false;
		}
		//실패하면 파일을 올릴 필요 없다.
		if(files == null || files.length == 0) {
			return true;
		}
		
		//여러개의 파일 업로드
		for(MultipartFile file : files) {
			uploadFile(board.getBo_num(), file);
		}
		
		return true;
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunityList();
	}

}
