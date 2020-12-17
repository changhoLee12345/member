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

@WebServlet("/BorderInput.do")
public class BorderInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BorderInputController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// command 구현없이 이곳에서 처리.

		request.setCharacterEncoding("utf-8");
		BorderDao dao = new BorderDao();
		BorderVO vo = new BorderVO();
		vo.setBorderWrite(request.getParameter("write")); // page의 name 변수명.
		vo.setBorderDate(Date.valueOf(request.getParameter("wdate"))); // 넘어온 wdate type을 문자로 변환.
		vo.setBorderTitle(request.getParameter("title"));
		vo.setBorderContent(request.getParameter("content"));

		String viewPage;
		int n = dao.insert(vo);
		if (n != 0) {
			response.sendRedirect("/Member/BorderList.do");
			// annotation 기반에서 서블릿 호출시에는 response 객체를 이용해서 호출.
		} else {
			String msg = "데이터베이스에 정상적으로 입력하지 못하였습니다.";
			request.setAttribute("msg", msg);
			viewPage = "jsp/border/inputError.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
