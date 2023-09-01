package co.yedam.project.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project.common.ViewResolve;
import co.yedam.project.member.service.MemberService;
import co.yedam.project.member.service.MemberVO;
import co.yedam.project.member.serviceImpl.MemberServiceImpl;

/**
 * Servlet implementation class memberlogin
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// service dao 생성
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		vo.setClientId(request.getParameter("clientId"));
		vo.setClientPassword(request.getParameter("clientPassword"));
		vo = dao.clientSelect(vo);
		if (vo != null) {
			request.setAttribute("message", "성공");
		}else {
			request.setAttribute("message", "실패");
		}
		
		String page = "member/membermessage";
		ViewResolve.views(request, response, page);
//		
//		String id = request.getParameter("clientId");
//		String password = request.getParameter("clientPassword");
		// dao 호출

		// 결과처리
//		request.setAttribute("id", id);
//		request.setAttribute("password", password);
//		String page = "member/membermessage";
//		ViewResolve.views(request, response, page);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
