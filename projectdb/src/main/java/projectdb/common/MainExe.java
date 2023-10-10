package projectdb.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import projectdb.notice.map.ReplyMapper;
import projectdb.notice.service.ReplyVO;

public class MainExe {
	public static void main(String[] args) {
		
	 SqlSession sqlSession = DataSource.getInstance().openSession(true);
	 ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);
	 
	 ReplyVO rvo = new ReplyVO();
	 rvo.setReplyId(1);
	 rvo.setNoticeId(1);
	 rvo.setReplyer("newb12");
	 rvo.setReply("댓글테스트22");
	 map.insert(rvo);
	
			
	
	List<ReplyVO> list = map.list(1);
	for(ReplyVO vo : list) {
		System.out.println(vo.toString());
	}
	}
}
