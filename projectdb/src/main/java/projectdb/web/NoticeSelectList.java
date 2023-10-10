package projectdb.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectdb.common.ViewResolve;
import projectdb.notice.service.NoticeService;
import projectdb.notice.service.NoticeVO;
import projectdb.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticeselectlist.do")
public class NoticeSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSelectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		
		notices = dao.noticeSelectList();
		request.setAttribute("notices", notices);
		
		String page="notice/noticeselectlist";
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
