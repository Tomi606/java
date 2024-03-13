package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.vo.MemberVO;

@Service //@Service 어노테이션이 있어야 컨트롤러에서 객체를 만들때 Imp을 자동으로 추가해줌
public class MemberServiceImp implements MemberService {

	@Autowired //자동으로 마이바티스 생성자 추가
	private MemberDAO memberDao;
	
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
		return memberDao.insertMember(member);
	}
	
}
