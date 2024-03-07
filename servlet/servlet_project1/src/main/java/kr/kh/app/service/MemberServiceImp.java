package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {

	//인스턴스가 아니다.
	private MemberDAO memberDao;
	
	public MemberServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signup(MemberVO memberVO) {
		if(memberVO == null 
		|| memberVO.getMe_id() == null
		|| memberVO.getMe_pw() == null
		|| memberVO.getMe_email() == null) {
			return false;
		}
		//정규표현식 체크 코드(본인이 할 것)
		
		//비밀번호 확인 체크 코드(본인)
		
		//아이디가 중복되면 예외 발생
		try {
			//다 true이면 반환(insert)
			return memberDao.insertMember(memberVO);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MemberVO login(LoginDTO loginDTO) {
		if(loginDTO == null) {
			return null;
		}
		//아이디를 주고 회원 정보를 요청
		MemberVO user = memberDao.selectMember(loginDTO.getId());
		//아이디가 잘못 입력되면
		if(user == null) {
			return null; //없다고 리턴
		}
		//아이디는 있고, 비번이 같은지 확인
		if(user.getMe_pw().equals(loginDTO.getPw())) {
			//같다면 user 리턴
			return user;
		}
		//비번이 다르면 null 리턴
		return null;
	}

	@Override
	public boolean checkId(String id) {
		MemberVO member = memberDao.selectMember(id);
		return member == null;
	}
}

