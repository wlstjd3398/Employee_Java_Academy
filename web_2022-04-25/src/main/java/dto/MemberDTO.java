package dto;


// VO : Value Object(값을 갖고 있을 객체)
// DTO : Data Transfer Object(다른 계층에 전달할 값을 갖고 있을 객체)
public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	
	
	public MemberDTO(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
