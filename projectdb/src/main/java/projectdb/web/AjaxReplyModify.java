package projectdb.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
 * Servlet implementation class AjaxReplyModify
 */
@WebServlet("/ajaxreplymodify.do")
public class AjaxReplyModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		String reply = request.getParameter("content");
		ReplyVO vo = new ReplyVO();
		
		vo.setReplyId(Integer.parseInt(rid));
		vo.setReply(reply);
		
		ReplyService svc = new ReplyServiceImpl();
		Map<String, Object> resultMap = new HashMap<>();
		if(svc.editRply(vo)) {
			vo = svc.getReply(Integer.parseInt(rid));
			resultMap.put("retCode", "Success");
			resultMap.put("data", vo);
		}else {
			resultMap.put("retCode", "Fail");
		}
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
