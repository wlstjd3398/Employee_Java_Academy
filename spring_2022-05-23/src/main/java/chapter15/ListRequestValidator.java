package chapter15;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ListRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ListRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "from", "required");
		ValidationUtils.rejectIfEmpty(errors, "to", "required");
		
	}

	
	
}
