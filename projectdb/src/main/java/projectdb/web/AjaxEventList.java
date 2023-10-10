package projectdb.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import projectdb.common.DataSource;
import projectdb.notice.map.ReplyMapper;
import projectdb.notice.service.EventVO;
import projectdb.notice.service.ReplyService;
import projectdb.notice.serviceImpl.ReplyServiceImpl;

/**
 * Servlet implementation class AjaxEventList
 */
@WebServlet("/ajaxeventlist.do")
public class AjaxEventList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);

	public AjaxEventList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		
		
		
		ReplyService dao = new ReplyServiceImpl();
		EventVO vo = new EventVO();
		
		List<EventVO> evo = map.listEvent();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(evo);

		
		response.getWriter().print(json);
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
