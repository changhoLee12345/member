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

@WebServlet("/MemberSignUp.do")
public class MemberSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberSignUpController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("id"));
		vo.setMemberName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		int n = dao.insert(vo);
		
		if(n!=0) {
			response.sendRedirect("/Member/jsp/member/loginPage.jsp");
		} else {
			String msg = "가입을 완료하지 못하였습니다.";
			request.setAttribute("msg", msg);
			
			String viewPage = "/Member/jsp/member/signUpError.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
