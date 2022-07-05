package vo;

public class BoardReviewInfo {
	private int idx;
	private String reviewWriter;
	private String reviewContent;
	
	
	public BoardReviewInfo(int idx, String reviewWriter, String reviewContent) {
		this.idx = idx;
		this.reviewWriter = reviewWriter;
		this.reviewContent = reviewContent;
	}


	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	
}
