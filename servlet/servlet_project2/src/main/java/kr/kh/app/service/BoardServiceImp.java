package kr.kh.app.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.utils.FileUploadUtils;

public class BoardServiceImp implements BoardService {

	private BoardDAO boardDao;
	//실제 D 드라이브에 uploads 폴더가 있어야 한다!
	private String uploadPath = "D:\\uploads";
	
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
		File file = new File(uploadPath);
		//해당 파일이 없으면 자동 추가(Creates the directory named by this abstract pathname.)
		if(!file.exists()) {
			file.mkdir();
		}
	}

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public boolean insertBoard(BoardVO board, ArrayList<Part> partList) {
		if(board == null
		|| !checkString(board.getBo_title())
		|| !checkString(board.getBo_content())) {
			return false;
		}
		
		boolean res = boardDao.insertBoard(board);
		//게시글 등록 실패
		if(!res) {
			return false;
		}
		//첨부파일이 없는 경우
		if(partList == null || partList.size() == 0) {
			return true;
		}
		for(Part part : partList) {			
			uploadFile(part, board.getBo_num());
		}
		return true;
	}
	
	private void uploadFile(Part part, int bo_num) {
		if(part == null || bo_num == 0) {
			return;
		}
		//서버에 업로드
		String fileOriginalName = FileUploadUtils.getFileName(part);
		//파일이름이 null 이거나 길이가 0이면 return
		if(!checkString(fileOriginalName)) {
			return;
		}
		String fileName = FileUploadUtils.upload("uploadPath", part);
		//DB에 추가
		FileVO fileVo = new FileVO(bo_num, fileName, fileOriginalName);
		boardDao.insertFile(fileVo);
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

	//문자열이 null이거나 빈 문자열이면 false, 아니면 true를 반환하는 메서드
		public boolean checkString(String str) {
			if(str == null || str.length() == 0) {
				return false;
			}
			return true;
		}
}
