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

@WebServlet("/MemberEdit.do")
public class MemberEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberEditController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setMemberId(request.getParameter("id"));
		vo.setMemberAuth(request.getParameter("auth"));
		vo.setMemberPoint(Integer.parseInt(request.getParameter("point")));
		int n = dao.update(vo);
		
		if(n!=0) {
			response.sendRedirect("/Member/MemberList.do");
		} else {
			String msg = "수정을 완료하지 못하였습니다.";
			request.setAttribute("msg", msg);
			
			String viewPage = "/Member/jsp/memberAdmin/editError.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
