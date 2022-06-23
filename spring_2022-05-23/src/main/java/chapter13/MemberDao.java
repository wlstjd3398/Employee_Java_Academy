package chapter13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

public class MemberDao {

	// 스프링은 쿼리를 실행하고 결과를 가져오기 위해서 JdbcTemplate을 사용함
	
//	private DataSource dataSource;
	// 다형성을 사용해서
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 날짜from to를 사용해서 회원정보를 조회
	public List<Member> selectByRegdate(LocalDateTime from, LocalDateTime to){
		List<Member> results = jdbcTemplate.query("SELECT * FROM member WHERE regdate BETWEEN ? AND ? ORDER BY regdate DESC", new MemberMapper(), from, to);
	
		return results;
	}
	
	
	public Member selectByEmail(String email) {
		String sql = "SELECT * FROM member WHERE email = ?";
		
		List<Member> results = jdbcTemplate.query(sql, new MemberMapper(),
//			List<Member> results = jdbcTemplate.query(sql, new RowMapper<Member>() {
//
//				// sql select의 결과를 RowMapper로 담아서 오버라이딩
//				// rs.next() 할 필요가 없음
//				@Override
//				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//					String email = rs.getString("email");
//					String password = rs.getString("password");
//					String name = rs.getString("name");
//					LocalDateTime regdate = rs.getTimestamp("regdate").toLocalDateTime();
//					
//					Member member = new Member(email, password, name, regdate);
//					
//					return member;
//				}
			
		email);
		// RowMapper에는 담아줄건 담아주고
		// 인덱스 파라미터를 세번째 인자 email로 사용해서  ? 에 사용
		
		
		return results.isEmpty() ? null : results.get(0);
		// results에 값이 없으면 null, 아니라면 회원정보 하나를 리턴함
	}

	
	public void insert(Member member) {
		// 1. 방법
//		jdbcTemplate.update("INSERT INTO member(email, password, name, regdate) VALUES(?, ?, ?, ?)",
//				member.getEmail(), member.getPassword(), member.getName(),
//				Timestamp.valueOf(member.getRegisterDateTime())
//		);
//		
//		// 회원가입 후 가입한 회원의 번호를 알고싶다
//		int memberNumber = jdbcTemplate.queryForObject("SELECT memberNumber FROM member WHERE email = ?", Integer.class, member.getEmail());
//		
//		System.out.println("가입한 사용자의 번호는 " + memberNumber + "번입니다.");
		
		// 2. 방법 
		// = = = = = [ KeyHolder를 사용해 회원가입 후 가입한 회원의 번호를 알고 싶다 를 해결 ] = = = = =
		// KeyHolder를 사용해서 AUTO_Increment 칼럼의 값을 알아내려면 반드시 PreparedStatement 를 사용해서 INSERT 쿼리를 사용해야함
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "INSERT INTO member(email, password, name, regdate) VALUES(?, ?, ?, ?)";
				
				PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"memberNumber"});
				// 배열을 생성하면서 "memberNumber" 데이터가 들어있는 배열을 생성
				// sql를 실행할때 memberNumber의 값을 가지고 옴
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));

				return pstmt;
			}
			
		}, keyHolder);
		// 가지고온 memberNumber값을 keyHolder에 저장함
		
		Number keyValue = keyHolder.getKey();
		
		// 컴파일오류는 위에서 이미 선언했기때문에
		long memberNumber = keyValue.longValue();
		
		System.out.println("가입한 사용자의 번호는 " + memberNumber + "번입니다.");
		
	}
	
	
	public void update(Member member) {
		// 두가지중에 한가지를 선택해서 사용하면됨
		
		
		// SELECT나 UPDATE를 할 때 인덱스 파라미터는 세번째 인자부터 넣어줬음
//		jdbcTemplate.update("UPDATE member SET name = ?, password = ? WHERE email = ?", member.getName(), member.getPassword(), member.getEmail());
	 // 1. 인덱스 파라미터를 순서대로 넣어서 update가능해짐
		
		
		
		// 2. jdbcTemplate을 사용해서 쿼리를 실행할 때 Servlet, JSP처럼 PreparedStatement를 사용할 수 있음
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "UPDATE member SET name = ?, password = ? WHERE email = ?";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getEmail());
				
				return pstmt;
			}
			
		});
		
		// WHERE 조건에 맞는 데이터가 없어서 UPDATE 쿼리가 정보를 수정하지 못했다면
		// EmptyResultDataAccessException 예외가 발생함
		
	}
	
	
	public Collection<Member> selectAll(){
		String sql = "SELECT * FROM member";
		
		// 리턴해주는건 List지만 부모 인터페이스인 Collection으로 다형성으로 리턴해주게함
		Collection<Member> results = jdbcTemplate.query(sql, new MemberMapper());
		
		return results;
	}
	
	
	// 회원 가입한 사용자들의 수
	public int count() {
		// 가입한 사용자들의 수를 셈
		String sql = "SELECT COUNT(*) FROM member";
		
		// 수를 받으니 Integer로 정수를 받음
//		{
			//
//						@Override
//						public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
			//
//							int count = rs.getInt(1);
//							
//							return count;
//						}
//						
//					});
//		return results.get(0);
		// 첫번째 가입한 회원의 숫자를 리턴함
		
		// select 결과가 간단할때는 아래처럼 queryForObject를 사용함
		// queryForObject() 메서드를 사용했을 때 쿼리 실행 결과가 없다면
		// queryForObject() 메서드가 EmptyResultDataAccessException 예외를 발생시킴
		// queyrForObject() 메서드를 사용할 때는 실행 결과가 반드시 있는 SELECT에서만 사용하는게 좋음
		int count = jdbcTemplate.queryForObject(sql, Integer.class); 
		
		return count;
	}
	
}
