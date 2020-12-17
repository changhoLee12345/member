package co.syeon.border.vo;

import java.sql.Date;

public class BorderVO {
	private int borderId;
	private String borderTitle;
	private String borderWrite;
	private String borderContent;
	private Date borderDate;
	private int borderHit;
	
	public int getBorderId() {
		return borderId;
	}
	public void setBorderId(int borderId) {
		this.borderId = borderId;
	}
	public String getBorderTitle() {
		return borderTitle;
	}
	public void setBorderTitle(String borderTitle) {
		this.borderTitle = borderTitle;
	}
	public String getBorderWrite() {
		return borderWrite;
	}
	public void setBorderWrite(String borderWrite) {
		this.borderWrite = borderWrite;
	}
	public String getBorderContent() {
		return borderContent;
	}
	public void setBorderContent(String borderContent) {
		this.borderContent = borderContent;
	}
	public Date getBorderDate() {
		return borderDate;
	}
	public void setBorderDate(Date borderDate) {
		this.borderDate = borderDate;
	}
	public int getBorderHit() {
		return borderHit;
	}
	public void setBorderHit(int borderHit) {
		this.borderHit = borderHit;
	}
	
	
	
	
}
