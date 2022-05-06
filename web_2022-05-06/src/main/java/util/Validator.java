package util;
//아이디 규칙 : 최소 4자, 최대 10자 입력가능, 영문 대소문자와 숫자 하나이상 포함
// 비밀번호 규칙 : 최소 6자, 최대 16자 입력가능, 영문 대소문자와 숫자 하나이상 포함
// 비밀번호확인 규칙 : 비밀번호와 같아야함
// 이름 규칙 : 3자만 가능, 한글만
// 연락처 규칙 : 010-1111-2222 와 같은 형식만 가능함 / 각 자리마다 하이픈이 반드시 있어야 하고 맨 앞 자리는 3자, 중간 자리는 4자, 마지막 자리는 4자이어야함
// 주소 규칙 : 특별시, 광역시, 시, 도 와 같이 주소 맨 앞 부분만 입력
// 이메일 규칙 : 반드시 @을 포함하고 있어야함

public class Validator {
	
	public boolean idValidator(String id) {
		// 아이디 규칙을 확인하는 코드
		boolean correctID = false;
		correctID = id.length() >= 4 && id.length()<= 10;
		
		if(!correctID) {
			// 아이디가 영문 대소문자와 숫자 하나 이상 포함하고 있는지 확인하는 코드
			// 예) iD123 -> 가능 / id123 -> 불가능(대문자 없음) / iD -> 불가능(숫자 없음)
			// iD12임 -> 불가능(영문 대소문자와 숫자 하나이상을 포함하고 있지만 그외에 한글 '임'이 들어있음)
			
			// 자바 수업자료 중 조건문, 반복문과 관련된 과제를 보면 아이디, 비밀번호를 체크하는 부분이 있음
			// 자바 정규표현식을 공부를 해서 적용해보기
			// (구글에서 아이디 정규 표현식 이런 키워드로 찾아서 그 정규 표현식을 해석할 수 있으면 됨)
			
			correctID [a-z][A-Z][0-9]
			
		}
		return correctID;
	}
	
	public boolean pwValidator(String pw) {
		// 비밀번호 규칙을 확인하는 코드
		
		boolean correctPW = false;
		
		return correctPW;
		
	}
	
	public boolean nameValidator(String name) {
		// 이름 규칙을 확인하는 코드

		boolean correctName = false;
		
		return correctName;
		
	}
	
	public boolean telValidator(String tel) {
		// 비밀번호 규칙을 확인하는 코드

		boolean correctTel = false;
		
		return correctTel;
		
	}
	
	public boolean addrValidator(String addr) {
		// 비밀번호 규칙을 확인하는 코드

		boolean correctAddr = false;
		
		return correctAddr;
		
	}
	
	public boolean emailValidator(String email) {
		// 비밀번호 규칙을 확인하는 코드

		boolean correctEmail = false;
		
		return correctEmail;
		
	}
	
}
