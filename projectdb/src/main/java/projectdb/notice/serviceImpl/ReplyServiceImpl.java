package projectdb.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import projectdb.common.DataSource;
import projectdb.notice.map.ReplyMapper;
import projectdb.notice.service.EventVO;
import projectdb.notice.service.ReplyService;
import projectdb.notice.service.ReplyVO;

public class ReplyServiceImpl implements ReplyService{
	
	
	 SqlSession sqlSession = DataSource.getInstance().openSession(true);
	 ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);

	@Override
	public boolean addRply(ReplyVO vo) {
		return map.insert(vo) == 1;
	}

	@Override
	public boolean editRply(ReplyVO vo) {
		return map.update(vo) == 1;
	}

	@Override
	public boolean delRply(int replyId) {
		return map.delete(replyId) == 1;
	}

	@Override
	public ReplyVO getReply(int replyId) {
		return map.select(replyId);
	}

	@Override
	public List<ReplyVO> listReply(int noticeId) {
		return map.list(noticeId);
	}

	@Override
	public List<EventVO> listEvent() {
		return map.listEvent();
	}
	

}
