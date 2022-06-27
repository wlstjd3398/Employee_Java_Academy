package chapter15;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{

	
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("index");
		// main으로 들어오는건 index이름으로 보여주겠다
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("message.label");
		ms.setDefaultEncoding("utf-8");
		
		return ms;
	}

	@Override
	public Validator getValidator() {
		return new RegisterRequestValidator();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor()).addPathPatterns("/edit/**", "/logout");
		// /edit/** edit으로 시작하는 모든을 의미함
		// edit으로 시작하는데 몇가지만 빼고싶다 하면 
		// .addPathPatterns("/edit/**", "/logout").excludePathPatterns("/edit/help", "/edit/product/**");으로 뺄수있음
	}
	
	//빈으로 등록하고 싱글톤의 장점이 생김
	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
	
	
	// 객체를 JSON으로 변환할때 지정한 타입의 멤버변수는 모두 같은 규칙으로 변환되도록 할수 있음
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 스프링은 자바 객체를 JSON으로 변환할 때 HttpMessageConverter를 사용
		// Jackson을 이용해서 자바 객체를 Json으로 변환하면 MappingJackson2HttpMessageConterters를 사용함
		
//		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
//				.json()
//				// 스프링은 날짜 타입 멤버변수의 값을 유닉스 타임스탬프로 변환해 사용하는것이 기본 설정
//				.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//				// 위 메서드는 featuresToDisable() 메서드 사용해서 기본 설정을 없앤것
//				// 그러면 스프링은 날짜 타입 멤버 변수의 값을 ISO-8601(yyyy-MM-ddTHH:mm:ss)형식으로 변환해 사용함
//				.build();
		// 알맹이는 objectMapper 위와 같음
		// 날짜를 featuresToDisable을 해주면 ISO-8601 형식으로 사용하게 해줌(yyyy-mm-dd HH:mm:ss형식)
		
		
		// 내가 지정한 형식으로 변환되도록 하려면 serializerByType() 메서드를 호출하면 됨
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
				.json()
				.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(dtf))
				.build();
		
		converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
		// 새롭게 등록한다
	}
	
	
}
