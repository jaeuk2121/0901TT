package projectdb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectdb.common.ViewResolve;
import projectdb.pb.service.ProductService;
import projectdb.pb.service.ProductVO;
import projectdb.productImpl.ProductServiceImpl;

/**
 * Servlet implementation class ProductItem
 */
@WebServlet("/productitem.do")
public class ProductItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService dao = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		vo.setCode(request.getParameter("itemCode"));
		System.out.println(request.getParameter("itemCode"));
		vo = dao.productSelect(vo);

		System.out.println(vo);
		request.setAttribute("products", vo);
		String page = "item";
		ViewResolve.forward(request, response, page);
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
