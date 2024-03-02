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
@Order(1)
public class SecurityAspect {
	
	private Logger logger = Logger.getLogger(SecurityAspect.class.getName());
	
	@Around("@annotation(ToLog)")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		
		logger.info("Security Aspect: Calling the intercepted method");
		Object returnedValue = joinPoint.proceed();
		logger.info("Security Aspect: Method executed and returned " + returnedValue);
		
		return returnedValue;
	}
}
