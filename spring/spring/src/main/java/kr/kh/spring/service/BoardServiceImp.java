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
import kr.kh.spring.model.vo.RecommendVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.utils.UploadFileUtils;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	@Resource
	private String uploadPath;

	//문법 체크 메서드
	private boolean checkStrinig(String str) {
		return str != null && str.length() != 0;
	}
	
	//첨부파일 업로드 메서드
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
	
	//첨부파일 삭제 메서드
	private void deleteFile(FileVO file) {
		if(file == null) {
			return;
		}
		//서버에서 삭제
		UploadFileUtils.deleteFile(uploadPath, file.getFi_name());
		//DB에서 삭제
		boardDao.deleteFile(file.getFi_num());
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

	@Override
	public BoardVO getBoard(int boNum) {
		return boardDao.selectBoard(boNum);
	}

	@Override
	public void updateView(int boNum) {
		boardDao.updateView(boNum);
	}

	@Override
	public ArrayList<FileVO> getFileList(int boNum) {
		return boardDao.selectFileList(boNum);
	}

	@Override
	public boolean deleteBoard(int num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//게시글 번호에 맞는 게시글을 가져옴
		BoardVO board = boardDao.selectBoard(num);
		//게시글이 없거나 작성자가 아니면 false를 리턴
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//맞으면 삭제 후 결과를 리턴
		//1. 첨부파일 삭제 및 DB에서 제거
		//1) 게시글 번호에 맞는 첨부파일 리스트를 가져옴
		ArrayList<FileVO> fileList = boardDao.selectFileList(num);
		//2) 첨부파일 리스트가 있으면 반복문으로 첨부파일을 삭제
		if(fileList != null) {
			for(FileVO file : fileList) {
				//게시글 수정 시에도 이 메서드 사용할 수 있다.
				deleteFile(file);
				
			}
		}
		//2. 게시글 삭제
			return boardDao.deleteBoard(num);
	}

	@Override
	public boolean updateBoard(BoardVO board, MemberVO user, MultipartFile[] file, int[] delNums) {
		//file은 없을 수도 있기 때문에 따로 null 체크는 하지 않는다.
		if(board == null
		||!checkStrinig(board.getBo_title())
		||!checkStrinig(board.getBo_content())) {
			return false;
		}
		if(user == null) {
			return false;
		}
		//작성자가 맞는지 확인
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		if(dbBoard == null
		||!dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//게시글 수정
		boolean res = boardDao.updateBoard(board);
		//게시글 수정에 실패 시 -> 첨부파일을 수정할 필요 X
		if(!res) {
			return false;
		}
		
		//첨부파일 수정
		//1. 새 첨부파일 추가
		if(file != null) {
			for(MultipartFile tmp : file) {				
				uploadFile(board.getBo_num(), tmp);
			}
		}
		//2. 삭제할 첨부파일 삭제
		if(delNums == null) {
			return true;
		}
		for(int tmp : delNums) {
			FileVO fileVo = boardDao.selectFile(tmp);
			deleteFile(fileVo);
		}
		
		return true;
	}

	@Override
	public int recommend(RecommendVO recommend, MemberVO user) {
		if(recommend == null) {
			return -2; //실패했을때(-1, 0, 1이 아닐때)
		}
		if(user == null) {
			return -2;
		}
		//작성자를 로그인한 회원으로 설정
		recommend.setRe_me_id(user.getMe_id());
		//기존 추천 정보가 있는지 확인
		RecommendVO dbRecommend = boardDao.selectRecommend(recommend);
		//없으면 추가
		if(dbRecommend == null) {
			boardDao.insertRecommend(recommend);
		}
		//있으면 수정
		else {
			//취소
			if(recommend.getRe_state() == dbRecommend.getRe_state()) {
				recommend.setRe_state(0);
			}
			boardDao.updateRecommend(recommend);
		}
		return recommend.getRe_state();
	}

	@Override
	public int getUserRecommend(int num, MemberVO user) {
		if(user == null) {
			return -2;
		}
		
		RecommendVO recommend = boardDao.selectRecommend(new RecommendVO(num, user.getMe_id()));
		return recommend == null ? -2 : recommend.getRe_state();
	}
	
}
