package projectdb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectdb.member.service.MemberService;
import projectdb.member.service.MemberVO;
import projectdb.serviceImpl.MemberServiceImpl;

/**
 * Servlet implementation class Ajaxmembercheck
 */
@WebServlet("/ajaxmembercheck.do")
public class Ajaxmembercheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajaxmembercheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo = dao.memberSelect(vo);
		String str = "Yes";
		
		if( vo != null) {
			str= "No";  //이미 존재하는 아이디 입니다.
			
		}
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(str);
			return;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
