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
//		//필수 항목 체크
//		if(member.getMe_id() == null
//		|| member.getMe_pw() == null
//		|| member.getMe_email() == null) {
//			return false;
//		}
//		//아이디 중복체크
//		ArrayList<MemberVO> mList = new ArrayList<MemberVO>();
//		int index = mList.indexOf(new MemberVO(member.getMe_id()));
//		if(member.getMe_id().equals(mList.get(index).getMe_id())) {
//			System.out.println("중복된 아이디 입니다.");
//			return false;
//		}
//		//각 항목 유효성 검사
//		String regExId = "$[a-zA-Z0-9]{6,12}^";
//		String regExPw = "$[a-zA-Z0-9!@#$%^]{8,15}^";
//		String regExEmail = "$[a-zA-Z0-9]@[a-z].com^";
//		
//		//id 유효성 검사
//		if(!Pattern.matches(member.getMe_id(), regExId)) {
//			return false;
//		}
//		//아이디는 OK, pw 유효성 검사
//		if(!Pattern.matches(member.getMe_pw(), regExPw)) {
//			return false;
//		}
//		//아이디, 비번 OK, email 유효성 검사
//		if(!Pattern.matches(member.getMe_email(), regExEmail)) {
//			return false;
//		}
		
		//아래 예외 처리는 아이디 중복체크 검사를 안 했기 때문에 발생하는 예외를 임시 처리하기 위한 방법
		try {
			boolean res = memberDao.insertMember(member);
			return res;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public MemberVO getMember(LoginDTO loginDto) {
		if(loginDto == null) {
			return null;			
		}
		//다오에게 아이디를 주면서 회원 정보를 가져오라고 시킴
		MemberVO user = memberDao.selectMember(loginDto.getId());
		//가져온 회원정보가 없으면 null return
		if(user == null) {
			return null;
		}
		//있으면 DB 정보의 비번과 사용자가 입력한 비번이 같으면 DB 정보를, 다르면 null 리턴
		//비번은 회원가입 시 암호화가 되어 관리되기 때문에 DB에서 직접 비교할 수 없다.(복호화할 수 없다.)
		//복호화 : 입력된 정보를 암호화하고 암호화된 정보를 다시 원래 정보로 돌려주는 것
		//그래서 비번 확인을 서버쪽에서 해야 함
		if(user.getMe_pw().equals(loginDto.getPw())) {
			return user;
		}
		return null;
	}
}
