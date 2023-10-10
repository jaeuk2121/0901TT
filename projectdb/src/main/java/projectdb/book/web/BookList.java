package projectdb.book.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectdb.book.service.BookService;
import projectdb.book.service.BookVO;
import projectdb.book.serviceImpl.BookServiceImpl;
import projectdb.common.ViewResolve;

/**
 * Servlet implementation class BookList
 */
@WebServlet("/booklist.do")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookVO vo = new BookVO();

		BookService dao = new BookServiceImpl();
		List<BookVO> listvo = new ArrayList<BookVO>();
		
		
		vo.setBookCode(request.getParameter("Code"));
		vo.setBookTitle(request.getParameter("Title"));
		vo.setBookWriter(request.getParameter("Writer"));
		vo.setBookPublisher(request.getParameter("Puble"));
		vo.setBookPrice(request.getParameter("Price"));
		
		
		int result = dao.bookInsert(vo);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
