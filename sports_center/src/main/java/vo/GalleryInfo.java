package vo;

import java.time.LocalDateTime;

public class GalleryInfo {
	private int idx;
	private String title;
	private String content;
	private String img;
	private String writer;
	private LocalDateTime insertDate;
	private int hits;
	
	
	public GalleryInfo(String title, String content, String writer, String img, LocalDateTime insertDate) {
		this.title = title;
		this.content = content;
		this.img = img;
		this.writer = writer;
		this.insertDate = insertDate;
	}
	
	public GalleryInfo(int idx, String title, String content, String img) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.img = img;
	}
	
	public GalleryInfo(int idx, String title, String content, String img, String writer, LocalDateTime insertDate) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.img = img;
		this.writer = writer;
		this.insertDate = insertDate;
	}
	
	public GalleryInfo(int idx, String title, String content, String img, String writer, LocalDateTime insertDate, int hits) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.img = img;
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

	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
