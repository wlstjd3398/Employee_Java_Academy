package chapter07;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

public class MemberDao {

	// 스프링은 쿼리를 실행하고 결과를 가져오기 위해서 JdbcTemplate을 사용함
	
//	private DataSource dataSource;
	// 다형성을 사용해서
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		return null;
	}

	public void insert(Member member) {
		
	}
	
	public void update(Member member) {
		
	}
	
	public Collection<Member> selectAll(){
		return null;
	}
	
	
}
