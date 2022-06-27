package chapter13;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("chapter13")
public class GlobalExceptionHandler {
// 예외를 처리하는 핸들러를 만들어 나열 가능 = 글로벌 예외처리기
	
	@ExceptionHandler(TypeMismatchException.class)
	public String handlerTypeMismatchException(TypeMismatchException e) {
		return "member/invalid";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException e) {
		return "member/noMember";
	}
}
