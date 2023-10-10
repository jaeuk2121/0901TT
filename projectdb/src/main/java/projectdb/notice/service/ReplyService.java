package projectdb.notice.service;

import java.util.List;

public interface ReplyService {
	public boolean addRply(ReplyVO vo);
	public boolean editRply(ReplyVO vo);
	public boolean delRply(int replyId);
	public ReplyVO getReply(int replyId);
	public List<ReplyVO> listReply(int noticeId);
	public List<EventVO> listEvent();
	

}
