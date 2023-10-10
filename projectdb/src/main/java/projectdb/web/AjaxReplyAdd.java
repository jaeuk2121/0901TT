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

@WebServlet("/ajaxreplyadd.do")
public class AjaxReplyAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nid = request.getParameter("nid");
		String reply = request.getParameter("content");
		String replyer = request.getParameter("writer");
		
		ReplyVO vo = new ReplyVO();
		vo.setNoticeId(Integer.parseInt(nid));
		vo.setReply(reply);
		vo.setReplyer(replyer);
		
		ReplyService svc = new ReplyServiceImpl();
		
		Map<String, Object> resultMap = new HashMap<>();
		if(svc.addRply(vo)) {
			resultMap.put("retCode", "Success");
			resultMap.put("data", vo);
		}else {
			resultMap.put("retCode", "Fail");
		}
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(resultMap);
		
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
