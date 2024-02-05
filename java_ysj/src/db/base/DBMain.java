package db.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DBMain {

	public static void main(String[] args) {
		//MySQL 설치 시 port 번호를 수정하지 않았다면 3306
		//포트번호를 통해서 연결
		String url = "jdbc:mysql://localhost:3306/test";
		String id = "root";
		String pw = "root";
		
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//con 연결객체 생성
			con = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e){
			//MySQL이 백그라운드로 실행이 안될 경우, url의 DB명 오타
			System.out.println("연결 실패");
		} catch (ClassNotFoundException e){
			//forName에 오타있는 경우, j connector가 연결이 안되있을 경우
			System.out.println("드라이버를 찾을 수 없습니다.");
		}
		
//		//1. insert문 예제
//		//1-1. statement를 이용한 예제
//		//괄호에 db에 없는 아이디 입력해야 함, 쌍따옴표 쓸려면 \"\"
//		String sql = "insert into member values('asdasd','pwasd', 'asd@naver.com', now())";
//		Statement stmt = null;
//		try{
//			stmt = con.createStatement();
//			//위의 sql 쿼리 실행
//			stmt.execute(sql); -> 실행할 때 마다 sql을 컴파일
//			System.out.println("회원 추가 성공");
//		} catch (SQLException e){
//			//한번 더 실행하면 이미 추가된 아이디라서 예외 발생
//			System.out.println("예외 발생");
//			//e.printStackTrace(); -> 어디서 예외가 발생했는지 확인
//		}
		
//		//1-2. PreparedStatement를 이용한 예제(주로 사용)
//		//String sql = "쿼리";
//		//예시 ?을 이용하여 값을 동적으로 변경
//		//String sql = "insert into member values(?,?,?,?)";
//		String sql = "insert into member values(?,?,?,now())";
//		PreparedStatement pstmt = null;
//		try{
//			pstmt = con.prepareStatement(sql); //->객체가 만들어질 때 sql을 통해 셋팅이 되있음
//			//?개수만큼 setxxx을 이용하여 바인딩 해야 함 -> 물음표가 3개면 set이 3개
//			pstmt.setString(1, "qweqwe"); //scanner로 받아서 처리
//			pstmt.setString(2, "pwqwe");
//			pstmt.setString(3, "qwe@naver.com");
//			//쿼리가 적용된 행의 개수(int)를 리턴. -> 3row(s) returned
//			pstmt.executeUpdate();
//		}catch(SQLException e){
//			System.out.println("예외 발생");
//		}
		
//		//2. update문 예제
//		String sql = "update member set pw = ? where id = ?";
//		PreparedStatement pstmt = null;
//		try{
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, "newPw");
//			pstmt.setString(2, "qweqwe");
//			pstmt.executeUpdate();
//			System.out.println("비번 수정 성공");
//		}catch(SQLException e){
//			System.out.println("예외 발생");
//		}
		
//		//3. delete문 예제
//		String sql = "delete from member where id = ?";
//		PreparedStatement pstmt = null;
//		try{
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, "qweqwe");
//			pstmt.executeUpdate();
//			System.out.println("회원 삭제 성공");
//		}catch(SQLException e){
//			System.out.println("예외 발생");
//		}
		
		//4. select문 예제
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// Member 인스턴스 list 저장
		List<Member> list = new ArrayList<Member>();
		try{
			pstmt = con.prepareStatement(sql);
			//쿼리에 ?가 있다면 pstmt.setXX을 통해 바인딩
			rs = pstmt.executeQuery();
			//검색된 행(레코드 만큼 반복)
			while(rs.next()){
				//검색 결과 첫번째 열이 id, 두번째 열이 pw이라고 가정
				//첫번째 열이 문자열이기 때문에 getString()을 이용
				//정수라면 getInt()
				String dbId = rs.getString(1);
				String dbPw = rs.getString(2);
				String dbEmail = rs.getString(3);
				Date dbRegDate = rs.getDate(4);
//				System.out.println("ID : " + dbId + ", PW : " + dbPw
//						+ ",EMAIL : " + dbEmail + ", 가입일 : " + dbRegDate);
				Member member = new Member(dbId, dbPw, dbEmail, dbRegDate);
				System.out.println(member); //toString
				//member 인스턴스 list에 추가
				list.add(member);
			}
		} catch (SQLException e){
			System.out.println("예외 발생");
		}
	}
}

@Data
@AllArgsConstructor
class Member {
	String id, pw, email;
	Date regDate;
}