package projectdb.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import projectdb.notice.service.NoticeService;
import projectdb.notice.service.NoticeVO;
import projectdb.notice.serviceImpl.NoticeServiceImpl;

/**
 * Servlet implementation class AjaxNoticeSearch
 */
@WebServlet("/ajaxnoticesearch.do")
public class AjaxNoticeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxNoticeSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule()); //json 형태의 데이터로 변환
		
		
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		
		notices = dao.noticeSelectList(key,val);
		String list = objectMapper.writeValueAsString(notices);  //list형태의 데이터를 json형태의 데이터로 변환
		
		response.setContentType("text/html; charset-UTF-8");
		response.getWriter().append(list);
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
