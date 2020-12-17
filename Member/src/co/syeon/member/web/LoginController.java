package co.syeon.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.syeon.member.dao.MemberDAO;
import co.syeon.member.vo.MemberVO;

@WebServlet("/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// command 없이 로그인 관련 module 처리.

		request.setCharacterEncoding("utf-8");
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(false); // 세션객체를 가져옴.

		vo.setMemberId(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));

		vo = dao.memberLoginCheck(vo);

		if (vo.getMemberAuth() != "") {
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("auth", vo.getMemberAuth());
			session.setAttribute("name", vo.getMemberName());
		}
		
		request.setAttribute("vo", vo);
		String viewPage = "jsp/member/loginResult.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
