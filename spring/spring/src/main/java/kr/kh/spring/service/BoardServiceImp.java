package kr.kh.spring.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.utils.UploadFileUtils;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	@Resource
	private String uploadPath;

	private boolean checkStrinig(String str) {
		return str != null && str.length() != 0;
	}
	
	private void uploadFile(int bo_num, MultipartFile file) {
		try {
			String originalFileName = file.getOriginalFilename();
			//파일명이 없으면
			if(originalFileName.length() == 0 ) {
				return;
			}
			//서버에 업로드 후 업로드한 파일명을 가져옴
			String fileName = 
					UploadFileUtils.uploadFile(uploadPath, originalFileName, file.getBytes());
			//FileVO 개체를 생성
			FileVO fileVo = new FileVO(bo_num, fileName, originalFileName);
			//DB에 추가
			boardDao.insertFile(fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if(user == null || board == null) {
			return false;
		}
		if(!checkStrinig(board.getBo_title())
		|| !checkStrinig(board.getBo_content())) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		boolean res = boardDao.insertBoard(board);
		//게시글 등록 실패(res가 거짓이면) => 첨부파일 올릴 필요 없음
		if(!res) {
			return false;
		}
		
		//첨부파일 업로드 작업
		//업로드할 파일이 없으면
		if(files == null || files.length == 0) {
			return true;
		}
		//있으면
		for(MultipartFile file : files) {
			//첨부파일을 서버에 업로드하고, DB에 추가
			uploadFile(board.getBo_num(), file);
		}
		
		return true;
	}
	
}