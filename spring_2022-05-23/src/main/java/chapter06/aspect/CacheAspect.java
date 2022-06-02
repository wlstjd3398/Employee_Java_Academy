package chapter06.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class CacheAspect {

	private Map<Long, Object> cache = new HashMap<>();
	
	
	@Pointcut("execution(public * chapter06.*.*(..))")
	public void cacheTarget() {
		
	}
	
	@Around("cacheTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		Long num =(Long) joinPoint.getArgs()[0];
		
		// 키가 존재하는지?
		// 앞에서 동작했으니 빨리 호출할수 있게 함
		if(cache.containsKey(num)) {
			long result = (long) cache.get(num);
			
			System.out.println("CacheAspect: Cache에서 " + num + "key의 값 " + result + " 찾음");
			return result;
		}
		
		// 핵심기능의 팩토리얼 동작
		Object result = joinPoint.proceed();
		
		cache.put(num, result);
		
		System.out.println("CacheAspect: Cache에 key = " + num + ", value = " + result + " 추가");
		
		// 핵심 기능이 동작한 것을 리턴
		return result;
	}
}
