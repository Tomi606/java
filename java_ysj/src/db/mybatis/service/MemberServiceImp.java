package db.mybatis.service;
//4번
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.mybatis.dao.MemberDAO;
import db.mybatis.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao; //imp는 memberDAO를 멤버변수로 가짐
	private InputStream inputStream;
	private SqlSession session;
	
	//serviceimp클래스 DAO 연결
	public MemberServiceImp() {
		String resource = "db/mybatis/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession();
			//Mapper.xml이랑 DAO를 연결하는 코드
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean insertMember(MemberVO member) {
		if(member == null 
				|| member.getId() == null 
				|| member.getPw() == null
				|| member.getEmail() == null) {
			return false;			
		}
		boolean res = memberDao.insertMember(member);
		if(res) {
			session.commit();
		}
		return res;
	}

	@Override
	public ArrayList<MemberVO> getMemberList() {
		return memberDao.selectMemberList();
	}

}
