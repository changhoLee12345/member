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

@WebServlet("/NoticeDelete.do")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeDeleteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		NoticeDAO dao = new NoticeDAO();
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeid(Integer.parseInt(request.getParameter("id")));
		int n = dao.delete(vo);
		
		if (n != 0) {
			response.sendRedirect("/Member/NoticeList.do");
		} else {
			String msg = "삭제하지 못하였습니다.";
			request.setAttribute("msg", msg);
			String viewPage = "jsp/notice/deleteError.jsp";

			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
