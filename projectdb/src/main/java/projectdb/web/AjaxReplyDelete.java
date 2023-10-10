package projectdb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectdb.notice.service.ReplyService;
import projectdb.notice.serviceImpl.ReplyServiceImpl;

/**
 * Servlet implementation class AjaxReplyDelete
 */
@WebServlet("/ajaxreplydelete.do")
public class AjaxReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String replyId = request.getParameter("rid");
		
		ReplyService svc = new ReplyServiceImpl();
		if(svc.delRply(Integer.parseInt(replyId))){	//replyId는 문자열이기에 integer.parseint로 변환
			response.getWriter().print("{\"retCod\": \"Success\"}");
		}else {
			response.getWriter().print("{\"retCod\": \"fail\"}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
