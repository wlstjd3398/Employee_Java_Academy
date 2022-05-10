package util;

public class Validator2 {
		// 정규표현식으로 고쳐서 카페에 올리기
		public boolean idValidator(String id) {
			boolean correctId = false;
			
			correctId = id.matches("^[a-zA-Z0-9]{4, 10}$");
			 if(!correctId) {
				 return false;
			 }
			 
			correctId = id.matches("^(?=.*[a-z])$");
			if(!correctId) {
				return false;
			}
			
			correctId = id.matches("^(?=.*[A-Z])$");
			if(!correctId) {
				return false;
			}
			
			correctId = id.matches("^(?=.*[0-9])$");
			if(!correctId) {
				return false;
			}
						
			return correctId;
			
		}
		public boolean pwValidator(String pw) {
			boolean correctPw = false;
			
			correctPw = pw.matches("^[a-zA-Z0-9]{6, 16}$");
			 if(!correctPw) {
				 return false;
			 }
			 
			 correctPw = pw.matches("^(?=.*[a-z])$");
			if(!correctPw) {
				return false;
			}
			
			correctPw = pw.matches("^(?=.*[A-Z])$");
			if(!correctPw) {
				return false;
			}
			
			correctPw = pw.matches("^(?=.*[0-9])$");
			if(!correctPw) {
				return false;
			}
			
			return correctPw;
		}
		
		public boolean nameValidator(String name) {
			boolean correctName = false;
			
			
			correctName = name.matches("^[가-힣]{3}+$");
			if(!correctName) {
				return false;
			}
			
			return correctName;
		}
		
		public boolean telValidator(String tel) {
			boolean correctTel = false;
			
			correctTel = tel.matches("^\\d{3}-\\d{4}-\\d{4}$");
			if(!correctTel) {
				return false;
			}
			return correctTel;
			
		}
		
		public boolean addrValidator(String addr) {
			
			String[] city = {"서울특별시", "부산광역시", "대구광역시", "인천광역시",
					"광주광역시", "대전광역시", "울산광역시", "세종특별자치시", "경기도", "강원도",
					"충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주특별자치도"};
			
			for(String name : city) {
				if(name.equals(addr)) {
					return true;
				}
			}
			
			return false;
		}
		
		public boolean emailValidator(String email) {
			boolean correctEmail = false;
			
			// 이메일 안에 @이 있으면 true / 없으면 false를 반환
			//방법1
			return email.contains("@");
			
			//방법2
//				for(int i=0; i<email.length(); i++) {
//				char ch = email.charAt(i);
//				
//				if(ch == '@') {
//					return true;
//				}
//			}
	//	
//		return false;
		}
}
