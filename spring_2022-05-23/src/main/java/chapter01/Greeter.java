package chapter01;

public class Greeter {

	private String format;
	
	public String greeter(String guest) {
		return String.format(format, guest);
	}

	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	
	
}
