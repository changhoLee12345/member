package co.syeon.notice.vo;

import java.sql.Date;

public class NoticeVO {
	private int noticeid;
	private String noticewriter;
	private String noticetitle;
	private String noticecontent;
	private int noticehit;
	private String noticeattach;
	private Date noticedate;
	
	public int getNoticeid() {
		return noticeid;
	}
	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}
	public String getNoticewriter() {
		return noticewriter;
	}
	public void setNoticewriter(String noticewriter) {
		this.noticewriter = noticewriter;
	}
	public String getNoticetitle() {
		return noticetitle;
	}
	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}
	public String getNoticecontent() {
		return noticecontent;
	}
	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}
	public int getNoticehit() {
		return noticehit;
	}
	public void setNoticehit(int noticehit) {
		this.noticehit = noticehit;
	}
	public String getNoticeattach() {
		return noticeattach;
	}
	public void setNoticeattach(String noticeattach) {
		this.noticeattach = noticeattach;
	}
	public Date getNoticedate() {
		return noticedate;
	}
	public void setNoticedate(Date noticedate) {
		this.noticedate = noticedate;
	}
	
	
}
