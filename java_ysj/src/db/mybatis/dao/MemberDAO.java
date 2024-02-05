package db.mybatis.dao;
//5번
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.mybatis.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("member")MemberVO member);

	ArrayList<MemberVO> selectMemberList();

}