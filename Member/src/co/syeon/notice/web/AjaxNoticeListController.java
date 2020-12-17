package co.syeon.notice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import co.syeon.notice.dao.NoticeDAO;
import co.syeon.notice.vo.NoticeVO;

@WebServlet("/AjaxNoticeList.do")
public class AjaxNoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxNoticeListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// todo. json 형태의 데이터를 리턴한다.

		response.setContentType("text/html; charset=utf-8");	// 파일을 줄때는 불필요. 객체를 줄때는 필요.
		response.setCharacterEncoding("utf-8");
		
		NoticeDAO dao = new NoticeDAO();

		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		list = dao.selectAll();
		
		JSONObject jsonobject = new JSONObject(); // 전체 대이터의 저장을 위해
		JSONObject data; // 하나의 레코드를 위해
		JSONArray jlist = new JSONArray(); // 레코드 배열을 위해

		PrintWriter out = response.getWriter();
		
		// json 객체생성
		for (NoticeVO vo : list) {
			data = new JSONObject();
			data.put("noticeid", vo.getNoticeid());
			data.put("noticetitle", vo.getNoticetitle());
			data.put("noticedate", vo.getNoticedate().toString());
			data.put("noticewriter", vo.getNoticewriter());
			data.put("noticehit", vo.getNoticehit());
			data.put("noticeattach", vo.getNoticeattach());
			jlist.add(data);
		}
		jsonobject.put("data", jlist);
		
		//System.out.println(jlist);	// [{"noticetitle":"str테스","noticewriter":"관리자",...
		//System.out.println(jsonobject); // {"data":[{"noticetitle":"str테스",...
		
		out.print(jsonobject);
		out.flush();
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
