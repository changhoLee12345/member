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

@WebServlet("/BorderRead.do")
public class BorderReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BorderReadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// command 없이 여기서 모두 처리하는 방법 구현 : @WebServlet 자체가 controller 역할 수행.

		request.setCharacterEncoding("utf-8");
		BorderDao dao = new BorderDao();
		BorderVO vo = new BorderVO();

		vo.setBorderId(Integer.valueOf(request.getParameter("id"))); // private int borderId; 넘어오는 값이 int라서 string으로 변환.
		vo = dao.selectOne(vo);
		request.setAttribute("vo", vo);
		
		String viewPage = "jsp/border/borderRead.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
