package db.mybatis.service;
//3번
import java.util.ArrayList;

import db.mybatis.model.vo.MemberVO;

public interface MemberService {

	boolean insertMember(MemberVO member);

	ArrayList<MemberVO> getMemberList();

}
