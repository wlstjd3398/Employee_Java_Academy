package chapter13;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// 이 설정 클래스가 가지고 있는 스프링 MVC 활성화하는 애노테이션
// 낮은버전 mvc는 수백줄의 코드를 bean등록해줘야함
// 높은버전 mvc는 애노테이션 하나로 대신 할 수 있음
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{

	// WebMvcConfigurer 인터페이스가 가지고 있는 메서드를 오버라이딩 한 이유
	// 스프링 MVC의 설정을 개발자가 직접 조정하기 위해

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// JSP를 이용해서 컨트롤러의 처리 결과를 클라이언트에게 전달하기 위해서 이 메서드를 오버라이딩했음
		
		// jsp() 메서드 : 컨트롤러의 처리 결과를(접두사, 접미사) 형태의 JSP로 전달하겠다라는 메서드
		
		// view가 눈에 보이는 접두사와 접미사를 붙여서 클라이언트에게 전달하도록 함 
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// DispatcherServlet 의 매핑 경로를 /로 주었을때, JSP/HTML/CSS 등을 올바르게 처리하기 위한 설정
		configurer.enable();
	}

	// MainController생성하는것보다 오버라이딩하는 이방법이 더 간단히 구현가능
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("index");
		
	}
	
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("message.label");
		ms.setDefaultEncoding("utf-8");
		
		return ms;
	}

	// 글로벌 애노테이션 오버라이딩
//	@Override
//	public Validator getValidator() {
//		return new RegisterRequestValidator();
//	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthCheckInterceptor()).addPathPatterns("/edit/**", "/logout");
		// /edit/** edit으로 시작하는 모든을 의미함
		// edit으로 시작하는데 몇가지만 빼고싶다 하면 
		// .addPathPatterns("/edit/**", "/logout").excludePathPatterns("/edit/help", "/edit/product/**");으로 뺄수있음
	}
	
	//빈으로 등록하고 싱글톤의 장점이 생김
	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
		
}
