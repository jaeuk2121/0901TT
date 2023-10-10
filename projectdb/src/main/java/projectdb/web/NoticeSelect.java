prrrrpackage projectdb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectdb.common.ViewResolve;
import projectdb.notice.service.NoticeService;
import projectdb.notice.service.NoticeVO;
import projectdb.notice.serviceImpl.NoticeServiceImpl;

/**
 * Servlet implementation class SelectNotice
 */
@WebServlet("/noticeselect.do")
public class NoticeSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		vo = dao.noticeSelect(vo);
		request.setAttribute("n", vo);
		String page = "notice/noticeselect2";
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
