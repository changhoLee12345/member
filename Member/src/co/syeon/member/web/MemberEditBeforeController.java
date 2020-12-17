package co.syeon.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.member.dao.MemberDAO;
import co.syeon.member.vo.MemberVO;

@WebServlet("/MemberEditBefore.do")
public class MemberEditBeforeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberEditBeforeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setMemberId(request.getParameter("id"));
		vo = dao.editBefore(vo);
		
		request.setAttribute("vo", vo);

		String viewPage = "jsp/memberAdmin/memberEdit.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
