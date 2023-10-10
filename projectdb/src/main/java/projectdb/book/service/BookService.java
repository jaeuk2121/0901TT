package projectdb.book.service;

import java.util.List;

public interface BookService {
	List<BookVO> bookSelectList();

	int bookInsert(BookVO vo);
}
