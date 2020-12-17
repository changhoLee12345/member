package co.syeon.border.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.border.dao.BorderDao;
import co.syeon.border.vo.BorderVO;

@WebServlet("/BorderDelete.do")
public class BorderDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BorderDeleteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// command 없이 삭제 module 구현.

		request.setCharacterEncoding("utf-8");
		BorderDao dao = new BorderDao();
		BorderVO vo = new BorderVO();

		vo.setBorderId(Integer.parseInt(request.getParameter("id")));
		int n = dao.delete(vo);
		
		if (n != 0) {
			response.sendRedirect("/Member/BorderList.do");
		} else {
			String msg = "삭제하지 못하였습니다.";
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
