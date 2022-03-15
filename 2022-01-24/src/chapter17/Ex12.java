package chapter17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 사내 도서 관리 프로그램 개발
		Book book1 = new Book("Java Master", 34500);
		Book book2 = new Book("JSP?Servlet 입문", 29000);
		
		// set을 왜 쓰냐? 특징을 정리해서 이해하고있어야함 
		Set<Book> bookList = new HashSet<>();
		
		bookList.add(book1);
		bookList.add(book2);
		System.out.println(bookList);
		
		Book book3 = new Book("JSP/Servlet 입문", 29000);
		// set에 같은 정보의 책이 출력되었음 
		// -> equals와 hascode 메서드로 오버라이딩해서 호출
		// add 동작시 equals 와 hashcode도 같이 동작
		
		bookList.add(book3);
		System.out.println(bookList);
		
//		똑같은 정보를 저장하지않는다 equals Hashset
		
		System.out.println("***** 사내 도서 목록 *****");
		// bookList를 사용해서 사내 도서들의 정보를 출력하세요
		for(Book book : bookList) {
			System.out.println("도서명 = " + book.getTitle());
			System.out.println("도서가격 = " + book.getPrice());
		}
		System.out.println("***** ***** ***** *****");
		
		
		// iterator도 해보기
		Iterator<Book> iterator = bookList.iterator();
		Book nthBook;
		
		while(iterator.hasNext()) {
			nthBook = iterator.next();
			System.out.println(nthBook);
			
		for() {
			
			
		}
			
		
		}
		
	}

}