package projectdb.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import projectdb.notice.service.ReplyService;
import projectdb.notice.service.ReplyVO;
import projectdb.notice.serviceImpl.ReplyServiceImpl;

@WebServlet("/ajaxreplylist.do")
public class AjaxReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxReplyList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nid = request.getParameter("nid");
		// 추가
		String param = request.getParameter("param");
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.listReply(Integer.valueOf(nid));

		if (param == null) {

			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(list);

			response.setContentType("text/json;charset=utf-8");

			PrintWriter out = response.getWriter();
			out.print(json);
		} else {
			// {"data":[["값"],[], ...]}
			String json = "{\"data\": [";
			int cnt = 0;
			for (ReplyVO vo : list) {
				json += "[" + "\"" + vo.getReplyId() + "\"," 
						+ "\"" + vo.getReply() + "\","
						+ "\"" + vo.getReplyer()+ "\","
						+ "\"" + vo.getReplyDate() + "\"" + "]";
				if (++cnt != list.size()) {
					json += ",";
				}
			}
			json += "]}";
			PrintWriter out = response.getWriter();
			out.print(json);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
