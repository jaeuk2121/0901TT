package projectdb.book.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import projectdb.book.map.BookMapper;
import projectdb.book.service.BookService;
import projectdb.book.service.BookVO;
import projectdb.common.DataSource;

public class BookServiceImpl implements BookService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BookMapper map = sqlSession.getMapper(BookMapper.class);
	
	
	@Override
	public List<BookVO> bookSelectList() {
		return map.bookSelectList();
	}

	@Override
	public int bookInsert(BookVO vo) {
		return map.bookInsert(vo);
	}

}
