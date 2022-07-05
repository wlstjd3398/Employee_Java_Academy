package vo;

import java.time.LocalDateTime;

public class BoardInfo {
	private int idx;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime insertDate;
	private int hits;
	
	
	public BoardInfo(String title, String content, String writer, LocalDateTime insertDate, int hits) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.insertDate = insertDate;
		this.hits = hits;
	}
	
	public BoardInfo(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public BoardInfo(int idx, String title, String content) {
		this.idx = idx;
		this.title = title;
		this.content = content;
	}
	
	public BoardInfo(int idx, String title, String content, int hits) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.hits = hits;
	}
	
	public BoardInfo(int idx, String title, String content, String writer, LocalDateTime insertDate, int hits) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.insertDate = insertDate;
		this.hits = hits;
	}
	
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public LocalDateTime getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(LocalDateTime insertDate) {
		this.insertDate = insertDate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
	
	
}
