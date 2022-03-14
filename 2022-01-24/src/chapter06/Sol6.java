package chapter06;

import java.util.Random;

public class Sol6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		
		int pc = random.nextInt(50)+1;
		int user = random.nextInt(50)+1;
		
		
		for(user=1; user<=50; user++) {
			if(pc==user) {
				break;
			}else if(user > pc) {
				System.out.println("Down!!");
				if(user + 5 > pc && user - 5 < pc) {
					System.out.println("Almost Down!!");
					break;
				}
			}else if(user < pc) {
				System.out.println("Up!!");
				if(user + 5 > pc && user - 5 < pc) {
					System.out.println("Almost Up!!");
					break;
				}
			}
		}System.out.println("Right!! You tired times = " + user);
		
		
	}

}
