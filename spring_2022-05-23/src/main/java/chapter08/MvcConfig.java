package chapter08;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// 이 설정 클래스가 가지고 있는 스프링 MVC 활성화하는 애노테이션
// 낮은버전 mvc는 수백줄의 코드를 bean등록해줘야함
// 높은버전 mvc는 애노테이션 하나로 대신 할 수 있음
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{

	
	// WebMvcConfigurer 인터페이스가 가지고 있는 메서드를 오버라이딩 한 이유
	// 스프링 MVC의 세부설정을 개발자가 직접 조정하기 위해
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// JSP를 이용해서 컨트롤러의 처리 결과를 클라이언트에게 전달하기 위햇 이 메서드를 오버라이딩했음
		
		// jsp() 메서드 : 컨트롤러의 처리 결과를(접두사, 접미사) 형태의 JSP로 전달하겠다라는 메서드
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// DispatcherServlet의 매핑 경로를 /로 주었을 때, JSP/HTML/CSS 등을 올바르게 찾기 위한 설정
		configurer.enable();
		
	}
	
	
	
}
