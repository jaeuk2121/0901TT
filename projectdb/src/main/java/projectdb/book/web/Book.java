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

@WebServlet("/books.do")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Book() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookVO vo = new BookVO();

		BookService dao = new BookServiceImpl();
		List<BookVO> listvo = new ArrayList<>();
		listvo = dao.bookSelectList();
		request.setAttribute("list", listvo);

		String page = "book/book";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
