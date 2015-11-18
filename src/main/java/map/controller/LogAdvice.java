package map.controller;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;

import org.apache.log4j.Logger;

@Aspect
public class LogAdvice {

	final static Logger logger = Logger.getLogger(LogAdvice.class);
	
	@After("execution(* map.service.UserService.*(..))")
	public void log(JoinPoint joinpoint) {
		logger.info(new Date() + " method= " + joinpoint.getSignature().getName());
	}
	
}