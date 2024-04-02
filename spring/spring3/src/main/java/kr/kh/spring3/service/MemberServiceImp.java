package kr.kh.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring3.dao.MemberDAO;
import kr.kh.spring3.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public int getMemberCount() {
		return memberDao.selectMemberCount();
	}

	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		
		MemberVO user = memberDao.selectMemberId(member.getMe_id());
		//아이디 중복 확인
		if(user != null) {
			System.out.println("중복된 아이디");
			return false;
		}
		
		//빈 문자열도 암호화를 적용하면 빈문자열이 아니기 때문에 가입이 될 수 있어서 처리
		if(member.getMe_pw() == null || member.getMe_pw().length() == 0) {
			return false;
		}
		//비밀번호 암호화
		String encodePw = passwordEncoder.encode(member.getMe_pw());
		//암호화된 비번을 member객체에 업데이트
		member.setMe_pw(encodePw);
		
		try {
			return memberDao.insertMember(member);
		}catch(Exception e) {
			//이메일이 없으면 예외 발생
			e.printStackTrace();
			return false;
		}
	}
}
