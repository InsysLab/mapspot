package map.controller;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAdvice {
	
	@Before("execution(* map.controller.HomeController.mainPage(..))")
	public void log(JoinPoint joinpoint) {
		System.out.println(new Date() + " method= " + joinpoint.getSignature().getName());
	}
	
}