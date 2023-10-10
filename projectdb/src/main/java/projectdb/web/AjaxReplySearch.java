package projectdb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import projectdb.notice.service.ReplyService;
import projectdb.notice.service.ReplyVO;
import projectdb.notice.serviceImpl.ReplyServiceImpl;

/**
 * Servlet implementation class AjaxReplySearch
 */
@WebServlet("/ajaxreplysearch.do")
public class AjaxReplySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplySearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		ReplyService svc = new ReplyServiceImpl();
		ReplyVO vo = svc.getReply(Integer.parseInt(rid));
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(vo);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().append(json);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
