package chapter13;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

	// 역으로 올라가면서 필요한 의존주입을 실행
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		
		
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUrl("jdbc:mariadb://localhost:3306/spring_2022-06-02");
		ds.setUsername("root");
		ds.setPassword("1234");
		
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		
		return ds;
	}
	
	@Bean
	public MemberDao memberDao() {
		MemberDao memberDao = new MemberDao(dataSource());
		
		return memberDao;
	}
	@Bean
	
	public AuthService authService() {
		AuthService authService = new AuthService();
		authService.setMemberDao(memberDao());
		
		return authService;
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		MemberRegisterService memberRegSvc = new MemberRegisterService();
		memberRegSvc.setMemberDao(memberDao());
		
		return memberRegSvc;
	}
	
	
	@Bean
	public RegistController registController () {
		return new RegistController(memberRegSvc());
	}
	
	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
	}
	
	@Bean
	public LoginController  loginController() {
		LoginController loginController = new LoginController();
		// 생성자 방식으로 불러왔기에 
		loginController.setAuthService(authService());
		
		return loginController;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public ChangePasswordController changePasswordController() {
		ChangePasswordController changePasswordController = new ChangePasswordController();
		
		ChangePasswordService changePasswordService = new ChangePasswordService();
		changePasswordService.setMemberDao(memberDao());
		
		changePasswordController.setChangePasswordService(changePasswordService);
		
		return changePasswordController;
	}
	
	
	@Bean
	public MemberListController memberListController() {
		MemberListController memberListController = new MemberListController();
		memberListController.setMemberDao(memberDao());
		
		return new MemberListController();
	}
	
}
