package chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegisterRequestValidator implements Validator{
	// 검증에서 사용할 정규표현식을 사용
	private static String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	
	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		
//		매개변수로 전달된 clazz의 데이터타입이 RegisterRequestValidator 데이터 타입인지 확인
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	// 일반적으로 구현하는 방법
	// - 검사 대상 객체(target)의 멤버 변수가 올바른지 검사
	// - 올바르지 않다면 검사 결과 객체(errors)의 rejectValue() 메서드를 사용해 에러 코드 저장
	
	@Override
	public void validate(Object target, Errors errors) {
RegisterRequest regReq = (RegisterRequest) target;	
		
		if(regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
			// email코드에  required이라는 값을 저장
		} else{
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if(!matcher.matches()) {
				
				errors.rejectValue("email", "bad");
			}
		}
		
		// 여기서 이상한 건(매개변수에 검사 대상 객체를 전달해주는 것이 없음)
		// 검사 대상 객체의 errors안에 검사 대상 객체가 들어가있음  
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
//		name 멤버변수 값이 올바르지 않으면 required를 errors에 담음
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		
		if(!regReq.getPassword().isEmpty()) {
			if(!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}
}
