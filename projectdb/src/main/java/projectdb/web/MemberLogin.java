package projectdb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projectdb.common.Sha256;
import projectdb.common.ViewResolve;
import projectdb.member.service.MemberService;
import projectdb.member.service.MemberVO;
import projectdb.serviceImpl.MemberServiceImpl;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/memberlogin.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		
		
		
		
	
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = dao.memberSelect(vo);
		if( vo != null) {
			//session 객체에 필요한 데이터를 담아준다.
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("name", vo.getMemberName());
			request.setAttribute("message", vo.getMemberName() + "님 환영합니다");
		}else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치 하지 않습니다.");
		}
		String page = "member/membermessage";
		ViewResolve.forward(request, response, page);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
