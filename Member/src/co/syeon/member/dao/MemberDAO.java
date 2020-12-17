package co.syeon.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.syeon.border.vo.BorderVO;
import co.syeon.member.vo.MemberVO;

public class MemberDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.16:1521:xe";
	private String user = "syeon";
	private String password = "1234";

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs = null;;

	private final String member_all = "SELECT * FROM member ORDER BY memberid ASC";
	private String member_one = "SELECT * FROM member WHERE memberid = ?";
	private final String memberlogin = "SELECT * FROM member WHERE memberid=? AND password=?";
	// private final String member_edit = "SELECT * FROM member WHERE memberid=?";
	private final String update = "UPDATE member SET memberauth=?, memberpoint=? WHERE memberid=?";
	private final String insert = "INSERT INTO member(memberid, membername, password, memberauth) VALUES(?,?,?,'user')";
	private final String duplication = "SELECT memberid FROM member WHERE memberid=?";

	public MemberDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Lib Error");
		} catch (SQLException e1) {
			System.out.println("DB연결 실패1");
		}
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 전체데이터
	public ArrayList<MemberVO> selectAll() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo;
		try {
			psmt = conn.prepareStatement(member_all);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberPoint(rs.getInt("memberpoint"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 검색
	public MemberVO select(MemberVO vo) {
		try {
			psmt = conn.prepareStatement(member_one);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberPoint(rs.getInt("memberpoint"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}

	public MemberVO memberLoginCheck(MemberVO vo) {
		try {
			psmt = conn.prepareStatement(memberlogin);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public MemberVO editBefore(MemberVO vo) {
		try {
			psmt = conn.prepareStatement(member_one);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberPoint(rs.getInt("memberpoint"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public int insert(MemberVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(insert);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getPassword());
			n = psmt.executeUpdate();
			System.out.println(n + "명의 회원이 가입하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	public int update(MemberVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(update);
			psmt.setString(1, vo.getMemberAuth());
			psmt.setInt(2, vo.getMemberPoint());
			psmt.setString(3, vo.getMemberId());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public MemberVO delete(MemberVO vo) {
		return vo;
	}

	public int duplicationCheck(String id) {
		try {
			psmt = conn.prepareStatement(duplication);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return 0; // 이미 존재하는 회원
			} else {
				return 1; // 가입 가능한 회원 아이디
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

} // end of dao
