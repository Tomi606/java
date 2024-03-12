package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;

@Service //@Service 어노테이션이 있어야 컨트롤러에서 객체를 만들때 Imp을 자동으로 추가해줌
public class MemberServiceImp implements MemberService {

	@Autowired //자동으로 마이바티스 생성자 추가
	private MemberDAO memberDao;

	@Override
	public int testCountMember() {
		return memberDao.selectMemberCount();
	}
	
}
