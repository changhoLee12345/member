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

@WebServlet("/BorderSearch.do")
public class BorderSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BorderSearchController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// command없이 module구현
		
		request.setCharacterEncoding("utf-8");
		BorderDao dao = new BorderDao();
		BorderVO vo = new BorderVO();

		vo.setBorderId(Integer.parseInt(request.getParameter("id")));
		vo = dao.selectSearch(vo);

		request.setAttribute("vo", vo);
		
		String viewPage = "jsp/border/borderEdit.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
