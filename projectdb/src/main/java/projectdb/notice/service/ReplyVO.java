package projectdb.notice.service;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int	replyId;
	private int	noticeId;
	private String replyer;
	private String reply;
	private Date replyDate;
	private Date updateDate;
}
