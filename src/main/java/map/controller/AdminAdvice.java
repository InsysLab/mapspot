package map.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.cache.Cache;
//
//import map.logging.ILogger;
//import map.logging.Logger;

@Aspect
public class AdminAdvice {
	
	final static Logger logger = Logger.getLogger(AdminAdvice.class);

	@After("execution(* map.service.AdminUserService.*(..))")
	public void log(JoinPoint joinpoint) {
		logger.info(new Date() +" Entering Method: " + joinpoint.getSignature().getName());
		Object[] args = joinpoint.getArgs();

		for (Object obj : args) {
			logger.info("Arg : " + obj.getClass().getName() + " - " + obj.toString());
		}
	}
	
	@AfterThrowing("execution(* map.service.AdminUserService.*(..))")
	public void exceptionHandling(JoinPoint joinpoint) {
		logger.error(new Date() +" Exception caused at Method: " + joinpoint.getSignature().getName());
		Object[] args = joinpoint.getArgs();
		for (Object obj : args) {
			logger.error("Arg : " + obj.getClass() + " - " + obj.toString());
		}
	}
}
