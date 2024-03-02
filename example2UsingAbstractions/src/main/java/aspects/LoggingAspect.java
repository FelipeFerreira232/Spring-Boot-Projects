package aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	/*
	@Around("execution(* services.*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		
		logger.info("Method " + methodName +
				" with parameters " + Arrays.asList(args) +
				" will execute");
		
		Object returnedByMethod = joinPoint.proceed();
		
		logger.info("Method executed and returned " + returnedByMethod);
		return returnedByMethod;
	}
	*/
	
	@Around("@annotation(ToLog)")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		
		logger.info("Loggging Aspect: Calling the intercepted method");
		Object returnedValue = joinPoint.proceed();
		logger.info("Logging Aspect: Method executed and returned " + returnedValue);
		
		return returnedValue;
	}
	
	/*
	@Around("@annotation(ToLog)")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		
		logger.info("Method " + methodName +
				" with parameters " + Arrays.asList(args) +
				" will execute");
		
		Object returnedByMethod = joinPoint.proceed();
		
		logger.info("Method executed and returned " + returnedByMethod);
		return returnedByMethod;
		
	}
	*/
}
