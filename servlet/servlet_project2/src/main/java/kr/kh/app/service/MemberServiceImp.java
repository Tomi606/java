package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {

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
	public boolean signup(MemberVO member) {
		if(member == null) {			
			return false;
		}
		//필수 항목 체크
		if(member.getMe_id() == null
		|| member.getMe_pw() == null
		|| member.getMe_email() == null) {
			return false;
		}
//		//아이디 중복체크
//		if(member.equals(new MemberVO(me_id))) {
//			System.out.println("있는 아이디 입니다.");
//			return false;
//		}
//		//각 항목 유효성 검사
//		if(member.getMe_id() != "$[a-zA-Z0-9]{8,15}^") {
//			System.out.println("아이디는 영 대소문자, 숫자 8~15자만 사용가능 합니다.");
//			return false;
//		}
//		else if(member.getMe_pw() != "$[a-zA-Z0-9!@#$%^]{8,15}^") {
//			System.out.println("비번은 영 대소문자, 숫자, 특수기호(!@#$%^) 8~15자만 사용가능 합니다.");
//			return false;
//		}
//		else if(member.getMe_email() !="$[a-zA-Z0-9]@[a-z].com^") {
//			System.out.println("이메일 양식에 맞춰 작성해주세요.");
//			return false;
//		}
//		else {
//			//모두 성공하면 회원가입 성공
//		}
		return memberDao.insertMember(member);
	}
}
