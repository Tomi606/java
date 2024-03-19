package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;

@Service //@Service 어노테이션이 있어야 컨트롤러에서 객체를 만들때 Imp을 자동으로 추가해줌
public class MemberServiceImp implements MemberService {

	@Autowired //자동으로 마이바티스 생성자 추가
	private MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	private boolean checkString(String str) {
		return str != null && str.length() != 0;
	}

	@Override
	public boolean insertMember(MemberVO member) {
		if(member == null
		|| !checkString(member.getMe_id())
		|| !checkString(member.getMe_pw())
		|| !checkString(member.getMe_email())) {
			return false;
		}
		//아이디 중복 체크 user = DB에서 가져온 정보, member = 입력받은 정보
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user != null) {
			return false;
		}
		//비번 암호화
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO login(LoginDTO loginDto) {
		if(loginDto == null
		|| !checkString(loginDto.getId())
		|| !checkString(loginDto.getPw())) {
			return null;
		}
		//아이디와 일치하는 회원 정보 가져옴
		MemberVO user = memberDao.selectMember(loginDto.getId());
		//비번 복호화 하지 않고 비교
		if(user == null || !passwordEncoder.matches(loginDto.getPw(), user.getMe_pw())) {
			return null;
		}
		return user;
	}

	@Override
	public boolean idCheck(String id) {
		MemberVO member = memberDao.selectMember(id);
		//회원정보가 없다는 뜻
		return member == null;
	}
	
}
