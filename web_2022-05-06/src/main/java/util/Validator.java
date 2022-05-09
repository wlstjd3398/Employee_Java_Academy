package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Validator {

	//아이디 규칙 : 최소 4자, 최대 10자 입력가능, 영문 대소문자와 숫자 하나이상 포함
	public boolean idValidator(String id) {
		boolean correctId = false;
		
		correctId = id.length() >= 4 && id.length() <= 10;
		
		if(!correctId) {
			// 아이디 길이가 4자 미만이거나 10자를 초과했다면 이미 내가 정한 아이디 규칙에 부합하지 않으므로
			// 다른 조건은 확인할 필요가 없음
			// 아이디 길이가 규칙에 부합하지 않으면 return false; 를 해주는 것
			return false;
		}
			// 아이디가 영문 대소문자와 숫자 하나 이상 포함하고 있는지 확인하는 코드
			// 예) iD123 -> 가능 / id123 -> 불가능(대문자 없음) / iD -> 불가능(숫자 없음)
			// iD12임 -> 불가능(영문 대소문자와 숫자 하나이상을 포함하고 있지만 그외에 한글 '임'이 들어있음)
			
			// 자바 수업자료 중 조건문, 반복문과 관련된 과제를 보면 아이디, 비밀번호를 체크하는 부분이 있음
			// 자바 정규표현식을 공부를 해서 적용해보기
			// (구글에서 아이디 정규 표현식 이런 키워드로 찾아서 그 정규 표현식을 해석할 수 있으면 됨)
			
			// ^[a-zA-Z0-9]+$ -> 영문 대소문자와 숫자만 가지고 있나요?
			// String regEx = ("^[a-zA-Z0-9]{4, 10}$");
			correctId = id.matches("^[a-zA-Z0-9]+$");
		if(!correctId) {
			// 아이디에 영문 대소문자와 숫자가 아닌 문자가 들어있을 경우 이미 내가 정한 아이디 규칙에 부합하지 않으므로
			// 다른 조건은 확인할 필요가 없음
			return false;
		}
		
		// 영문 소문자 하나 이상 포함 여부
		for(int i=0; i<id.length(); i++) {
			char ch = id.charAt(i);
			
			correctId = ch >= 'a' &&  ch <= 'z';
			if(correctId) {
				// id의 n번째 문자가 소문자 일 경우
				// id가 소문자를 하나 이상 포함하고 있으므로
				// 그 뒤에 문자들은 확인할 필요가 없음
				break;
			}
		}
		// 위 for문을 돌면서 id 안에 소문자가 하나도 없을 경우에는 corretId = false 인 상태로 for문이 끝남
		if(!correctId) {
			return false;
		}
		
		// 영문 대문자 하나 이상 포함 여부
		for(int i=0; i<id.length(); i++) {
			char ch = id.charAt(i);
			
			correctId = ch >= 'A' &&  ch <= 'Z';
			if(correctId) {
				break;
			}
		}
		if(!correctId) {
			return false;
		}
		
		// 숫자 하나 이상 포함 여부
		for(int i=0; i<id.length(); i++) {
			char ch = id.charAt(i);
			
			correctId = ch >= '0' &&  ch <= '9';
			if(correctId) {
				break;
			}
		}
		if(!correctId) {
			return false;
		}
		
		return correctId;
	}
	
	//비밀번호 규칙 : 최소 6자, 최대 16자 입력가능, 영문 대소문자와 숫자 하나이상 포함
	//비밀번호확인 규칙 : 비밀번호와 같아야함
	public boolean pwValidator(String pw) {
		boolean correctPw = false;
		
//		String regEx = ("^[a-zA-Z0-9]{6, 16}$");
		
		correctPw = pw.length() >= 6 && pw.length() <= 16;
		
		if(!correctPw) {
			return false;
		}
		if(!correctPw) {
			return false;
		}
		
		for(int i=0; i<pw.length(); i++) {
			char ch = pw.charAt(i);
			
			correctPw = ch >= 'a' &&  ch <= 'z';
			if(correctPw) {
				break;
			}
		}
		if(!correctPw) {
			return false;
		}
		
		for(int i=0; i<pw.length(); i++) {
			char ch = pw.charAt(i);
			
			correctPw = ch >= 'A' &&  ch <= 'Z';
			if(correctPw) {
				break;
			}
		}
		if(!correctPw) {
			return false;
		}
		
		for(int i=0; i<pw.length(); i++) {
			char ch = pw.charAt(i);
			
			correctPw = ch >= '0' &&  ch <= '9';
			if(correctPw) {
				break;
			}
		}
		if(!correctPw) {
			return false;
		}
		
		return correctPw;
	}
	
	//이름 규칙 : 3자만 가능, 한글만
	public boolean nameValidator(String name) {
		boolean correctName = false;
		
//		String regEx = ("^[가-힣]{3}$");
		
		correctName = name.length() == 3;
		if(!correctName) {
			return false;
		}
		// 한글만 포함 여부 
		correctName = name.matches("^[가-힣]+$");
		return correctName;		
		
	}
	
	//연락처 규칙 : 010-1111-2222 와 같은 형식만 가능함 / 각 자리마다 하이픈이 반드시 있어야 하고 맨 앞 자리는 3자, 중간 자리는 4자, 마지막 자리는 4자이어야함
	public boolean telValidator(String tel) {
		boolean correctTel = false;
		
//		String regEx = ("^01(?:0|1)-\\d{4}-\\d{4}$");
		
		// split 메서드와 length 메서드를 활용해서 연락처를 확인하는 코드를 만드세요
		// split 메서드는 배우지 않았음
		// 배우지 않은 메서드를 사용하려면?
		
//		tel.split("-") ["010", "1234", "5678"]
//		01012345678, 010-12345678, 0101234-5678
		String[] tels = tel.split("-");
		if(tels[0].length() != 3) {
			return false;
		}else if(tels[0].length() != 3) {
			return false;
		}else if(tels[1].length() != 4 || tels[2].length() != 4) {
			return false;
		}
		
		return true;
	}
	
	//주소 규칙 : 특별시, 광역시, 시, 도 와 같이 주소 맨 앞 부분만 입력
	public boolean addrValidator(String addr) {
		
//		String regEx = ("^[가-힣]{5}$"); -> 정규표현식을 사용하는 경우는 패턴을 만들수 있는 경우!!
		
		String[] city = {"서울특별시", "부산광역시", "대구광역시", "인천광역시",
				"광주광역시", "대전광역시", "울산광역시", "세종특별자치시", "경기도", "강원도",
				"충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주특별자치도"};
		// addr 매개변수에 들어있는 값이 위 배열이 가지고 있는 17개 행정구역이 아닐 경우 false를 반환하도록
		// addr 매개변수에 들어있는 값이 17개 행정구역 중 하나라면 true를 반환해야함
		
		// 반복문을 돌면서 addr 변수에 들어있는 값이 17개 행정구역 중 하나라면 true를 반환해라
		
		for(String name : city) {
			if(name.equals(addr)) {
				return true;
			}
		}
		
		return false;
	}
	
	//이메일 규칙 : 반드시 @을 포함하고 있어야함
	public boolean emailValidator(String email) {
		boolean correctEmail = false;
		
//		String regEx = ("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$");
		
		// 이메일 안에 @이 있으면 true / 없으면 false를 반환
		//방법1
		return email.contains("@");
		
		//방법2
//		for(int i=0; i<email.length(); i++) {
//			char ch = email.charAt(i);
//			
//			if(ch == '@') {
//				return true;
//			}
//		}
//		
//		return false;
	}
}