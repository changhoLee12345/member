package co.syeon.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.member.dao.MemberDAO;

@WebServlet("/IdDuplication.do")
public class IdDuplicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IdDuplicationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		MemberDAO dao = new MemberDAO();
		
		String id = request.getParameter("id");
		response.getWriter().write(dao.duplicationCheck(id) + "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
