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

@WebServlet("/NoticeRead.do")
public class NoticeReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeReadController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		NoticeDAO dao = new NoticeDAO();
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeid(Integer.valueOf(request.getParameter("id")));
		vo = dao.select(vo);
		request.setAttribute("vo", vo);
		
		String viewPage = "jsp/notice/noticeRead.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
