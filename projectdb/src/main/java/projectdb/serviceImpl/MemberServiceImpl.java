package projectdb.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import projectdb.common.DataSource;
import projectdb.member.map.MemberMapper;
import projectdb.member.service.MemberService;
import projectdb.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {

		private SqlSession sqlSession = DataSource.getInstance().openSession(true);
		private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public List<MemberVO> memberSelectList() {
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return 0;
	}

}
