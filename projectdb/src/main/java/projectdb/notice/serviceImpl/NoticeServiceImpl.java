package projectdb.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import projectdb.common.DataSource;
import projectdb.notice.map.NoticeMapper;
import projectdb.notice.service.NoticeService;
import projectdb.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
			
	
	

	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		map.noticeHitUpdate(vo.getNoticeId()); //조회수를 증가시킴
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public void noticeHitUpdate(int id) {
		
	}

	@Override
	public List<NoticeVO> noticeSelectList(String key, String val) {
		return map.noticeSelectList(key, val);
	}
	
}
