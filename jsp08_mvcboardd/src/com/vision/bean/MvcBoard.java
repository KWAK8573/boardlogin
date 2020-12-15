package com.vision.bean;

import java.sql.Timestamp;

public class MvcBoard {
	private long bId; // 자동증가
	private String mId; // 게시자 아이디
	private String bTitle; // 게시글 제목
	private String bContent; // 게시글 내용
	private Timestamp bDate; // 게시일시
	private int bHit; // 게시글읽은 횟수
	private int bGroup; // 소속본글 bId
	private int bStep; // 댓글의 게시순서
	private int bIndent; // 리스트에 댓글의 갯글등 들여쓰기
	
	public long getbId() {
		return bId;
	}
	public void setbId(long bId) {
		this.bId = bId;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbIndent() {
		return bIndent;
	}
	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	@Override
	public String toString() {
		return "MvcBoard [bId=" + bId + ", mId=" + mId + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bDate="
				+ bDate + ", bHit=" + bHit + ", bGroup=" + bGroup + ", bStep=" + bStep + ", bIndent=" + bIndent + "]";
	}
	
}
