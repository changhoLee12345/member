package co.syeon.border.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import co.syeon.border.vo.BorderVO;
import co.syeon.common.DAO;

/*
 * 편의를 위해 상위 DAO 상속받아 사용.
 * 
CREATE sequence b_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOCYCLE;

SELECT b_seq.CURRVAL FROM dual;

 */

public class BorderDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	private final String select_all = "SELECT * FROM BORDER ORDER BY BORDERID DESC";
	private final String select_one = "SELECT * FROM BORDER WHERE borderid = ?";
	private final String insert = "INSERT INTO border(borderid, borderwriter, bordertitle, bordercontent, borderdate)\r\n"
			+ "VALUES(b_seq.nextval, ?, ?, ?, ?)";
	private final String hit_update = "UPDATE border SET borderhit = borderhit + 1 WHERE borderid = ?";
	private final String update = "UPDATE border SET bordercontent=? WHERE borderid = ?";
	private final String dalete = "DELETE FROM border WHERE borderid=?";
	

	// 전체 데이터 가져오기.
	public ArrayList<BorderVO> selectAll() {
		ArrayList<BorderVO> list = new ArrayList<BorderVO>();
		BorderVO vo;
		try {
			psmt = conn.prepareStatement(select_all);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BorderVO(); // borderVO값 초기화.
				vo.setBorderId(rs.getInt("borderid"));
				vo.setBorderWrite(rs.getString("borderwriter"));
				vo.setBorderTitle(rs.getString("bordertitle"));
				vo.setBorderContent(rs.getString("bordercontent"));
				vo.setBorderDate(rs.getDate("borderdate"));
				vo.setBorderHit(rs.getInt("borderhit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list; // 돌아오는 데이터가 없으면 return에 null을 반환.
	}

	// 한 레코드 검색 -> if.
	public BorderVO selectOne(BorderVO vo) {
		try {
			psmt = conn.prepareStatement(select_one);
			psmt.setInt(1, vo.getBorderId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				// 조회수 증가.
				psmt = conn.prepareStatement(hit_update);
				psmt.setInt(1, vo.getBorderId());
				psmt.executeUpdate();

				vo.setBorderId(rs.getInt("borderid"));
				vo.setBorderWrite(rs.getString("borderwriter"));
				vo.setBorderTitle(rs.getString("bordertitle"));
				vo.setBorderContent(rs.getString("bordercontent"));
				vo.setBorderDate(rs.getDate("borderdate"));
				vo.setBorderHit(rs.getInt("borderhit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// 게시글 입력
	public int insert(BorderVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(insert);
			psmt.setString(1, vo.getBorderWrite());
			psmt.setString(2, vo.getBorderTitle());
			psmt.setString(3, vo.getBorderContent());
			psmt.setDate(4, vo.getBorderDate());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 데이터베이스에 입력 완료 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// 수정버튼->뿌려주는 data
	public BorderVO selectSearch(BorderVO vo) {
		try {
			psmt = conn.prepareStatement(select_one);
			psmt.setInt(1, vo.getBorderId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setBorderId(rs.getInt("borderid"));
				vo.setBorderWrite(rs.getString("borderwriter"));
				vo.setBorderTitle(rs.getString("bordertitle"));
				vo.setBorderContent(rs.getString("bordercontent"));
				vo.setBorderDate(rs.getDate("borderdate"));
				vo.setBorderHit(rs.getInt("borderhit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// 게시글 수정
	public int update(BorderVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(update);
			psmt.setString(1, vo.getBorderContent());
			psmt.setInt(2, vo.getBorderId());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 수정 완료 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// 게시글 삭제
	public int delete(BorderVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(dalete);
			psmt.setInt(1, vo.getBorderId());
			n = psmt.executeUpdate();
			System.out.println(n + "한 건이 삭제 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// close() 메서드 총괄.
	private void close() {
		try {
			if (rs != null) {
				rs.close();
				System.out.println("rs클로즈");
			}
			if (psmt != null) {
				psmt.close();
				System.out.println("psmt클로즈");
			}
			if (conn != null) {
				conn.close();
				System.out.println("conn클로즈");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 글목록 갯수
	public ArrayList<BorderVO> getBoardList(HashMap<String, Object> listOpt) {
		ArrayList<BorderVO> list = new ArrayList<BorderVO>();
		
		String opt = (String)listOpt.get("opt");	// 검색옵션(제목,내용,글쓴이 등)
		String condition = (String)listOpt.get("condition");	// 검색내용
		int start = (Integer)listOpt.get("start");	// 현재 페이지 번호
		return null;
	}
}
