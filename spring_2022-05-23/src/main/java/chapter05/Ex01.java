package chapter05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Context.class);
		
		Client2 c1 = ctx.getBean("client2", Client2.class);
		Client2 c2 = ctx.getBean("client2", Client2.class);
		// scope 사용해서 client2 각각 만들어서 꺼내줌 -> 다른 것이 됨
		
		System.out.println(c1 == c2);
		
//		c.send();
		
		ctx.close();
		
		
		
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Context.class);
//		
//		Client client = ctx.getBean("client", Client.class);
//		client.setHost("127.0.0.1");
//		
//		client.send();
//		
//		ctx.close();
		
	}
	
}
