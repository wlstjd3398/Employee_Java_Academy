package chapter06;

public class Sol25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] str = {"America", "Break", "Manhours", "Agitation", "Ejector"};
		
		
//		str[i].length();
		
		for(int i=0; i<=3; i++) {
			if(str[i].length()>=str[i+1].length()) {
				System.out.println(str[i]);
			}else {
				System.out.println(str[i+1]);
			}
			
		}
	}

}
