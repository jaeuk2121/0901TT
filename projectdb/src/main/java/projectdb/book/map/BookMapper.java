package projectdb.book.map;

import java.util.List;

import projectdb.book.service.BookVO;

public interface BookMapper {
	List<BookVO> bookSelectList();

	int bookInsert(BookVO vo);
}
