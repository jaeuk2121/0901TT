package projectdb.web;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import projectdb.common.Thumbnail;
import projectdb.common.ViewResolve;
import projectdb.notice.service.NoticeService;
import projectdb.notice.service.NoticeVO;
import projectdb.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticewrite.do")
public class NoticeWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeWrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일 업로드 처리
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		Thumbnail thumbnail = new Thumbnail(); //썸네일클래스
		
		
		String saveDir = getServletContext().getRealPath("attech/notice");
		int maxSize = 1024*1024*100; //100Mbyte
		MultipartRequest multi = new MultipartRequest(
				request,
				saveDir,
				maxSize,
				"utf-8",
				new DefaultFileRenamePolicy());
		
		String imgFileName = multi.getOriginalFileName("imgfile"); //원본파일명
		String realImage = multi.getFilesystemName("imgfile"); //저장되는 파일명
		
		vo.setNoticeImage(realImage); //이미지 파일명을 저장한다.
		String filePath = saveDir + File.separator + imgFileName;
		String thumb = thumbnail.makeThumnail(filePath);
		
		
		
		
		String attech = multi.getOriginalFileName("attechfile");
		if(attech != null) {
			String attechFile = multi.getFilesystemName("attechfile");
			vo.setNoticeAttech(attechFile);
			
		}

		thumb = thumb.substring(thumb.lastIndexOf("\\")+1);
		vo.setNoticeThumbnail(thumb);
		
		vo.setNoticeWriter(multi.getParameter("noticeWriter"));
		vo.setNoticeDate(LocalDate.parse(multi.getParameter("noticeDate")));
		vo.setNoticeTitle(multi.getParameter("noticeTitle"));
		vo.setNoticeSubject(multi.getParameter("noticeSubject"));
		vo.setNoticeName(multi.getParameter("noticeName"));
		
		
		
		int n= dao.noticeInsert(vo);
		System.out.println(n);
		if(n !=0) {
			
			response.sendRedirect("noticeselectlist.do");
		}else {
			request.setAttribute("message", "게시글 등록이 실패했습니다");
			String page = "notice/noticemessage";
			ViewResolve.forward(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
