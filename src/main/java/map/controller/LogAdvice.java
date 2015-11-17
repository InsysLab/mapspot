package map.controller;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;

@Aspect
public class LogAdvice {

//	@After("execution(* map.service.UserService.*(..))")
//	public void log(JoinPoint joinpoint) {
//		System.out.println(new Date() + " method= " + joinpoint.getSignature().getName());
//	}
//	
}