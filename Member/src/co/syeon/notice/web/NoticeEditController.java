package co.syeon.notice.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.notice.dao.NoticeDAO;
import co.syeon.notice.vo.NoticeVO;

@WebServlet("/NoticeEdit.do")
public class NoticeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeEditController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		NoticeDAO dao = new NoticeDAO();
		NoticeVO vo =  new NoticeVO();
		
		vo.setNoticeid(Integer.parseInt(request.getParameter("id")));
		vo.setNoticecontent(request.getParameter("content"));
		vo.setNoticeattach(request.getParameter("attatchfile"));
		int n = dao.update(vo);
		
		if (n != 0) {
			response.sendRedirect("/Member/NoticeList.do");
		} else {
			String msg = "수정을 완료하지 못하였습니다.";
			request.setAttribute("msg", msg);
			
			String viewPage = "/Member/jsp/notice/editError.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
