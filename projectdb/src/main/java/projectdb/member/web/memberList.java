package projectdb.member.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectdb.common.ViewResolve;
import projectdb.member.service.MemberService;
import projectdb.member.service.MemberVO;
import projectdb.serviceImpl.MemberServiceImpl;

@WebServlet("/memberlist.do")
public class memberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public memberList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = dao.memberSelectList();
		request.setAttribute("members", list);
		
		String page = "member/memberlist";
		ViewResolve.forward(request, response, page);
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
