package projectdb.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import projectdb.notice.service.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	
	void noticeHitUpdate(int id);
	
	List<NoticeVO> noticeSelectList(@Param("key")String key,@Param("val")String val); //매개변수 2개를 쓰면 @Param 사용
	
	
}
