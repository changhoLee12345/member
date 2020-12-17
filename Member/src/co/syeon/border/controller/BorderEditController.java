package co.syeon.border.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.border.dao.BorderDao;
import co.syeon.border.vo.BorderVO;

@WebServlet("/BorderEdit.do")
public class BorderEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BorderEditController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// command없이 module구축.
		request.setCharacterEncoding("utf-8");
		BorderDao dao = new BorderDao();
		BorderVO vo = new BorderVO();
		
		vo.setBorderId(Integer.parseInt(request.getParameter("id")));
		vo.setBorderContent(request.getParameter("content"));
		int n = dao.update(vo);

		if (n != 0) {
			response.sendRedirect("/Member/BorderList.do");
		} else {
			String msg = "수정하지 못하였습니다.";
			request.setAttribute("msg", msg);
			String viewPage = "jsp/border/inputError.jsp";

			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
