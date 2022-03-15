package chapter06;

import java.util.Scanner;

public class Sol7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanf = new Scanner(System.in);
		String[] menuList = {"돈까스", "스파게티", "스테이크", "제육볶음"};
		
		System.out.println("어떤 음식을 주문하시겠습니까?");
		String menu = scanf.next();
		
		boolean exist = false;
		for(int i=0; i<menuList.length; i++) {
			if(!exist) exist = menuList[i].equals(menu);
		}
		
//		if(!exist) exist = menuList[0].equals(menu);
//		if(!exist) exist = menuList[1].equals(menu);
//		if(!exist) exist = menuList[2].equals(menu);
//		if(!exist) exist = menuList[3].equals(menu);
		
		if(exist) System.out.println("주문하신 " + menu + " 이(가) 접수되었습니다.");
		else System.out.println("주문하신 " + menu + " 은(는) 없는 메뉴입니다.");

		
	}

}