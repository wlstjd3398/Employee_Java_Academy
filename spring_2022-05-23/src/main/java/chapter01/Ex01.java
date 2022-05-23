package chapter01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		// new 객체를 사용하지 않고 빈을 통해서 새로운 객체를 생성하고 greeter를 불러옴
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greeter("스프링");
		
		System.out.println(msg);
		
		ctx.close();
		
		
	}
	
}
