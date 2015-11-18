package map.controller;

import java.util.Date;

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

	@After("execution(* map.service.AdminUserService.*(..))")
	public void log(JoinPoint joinpoint) {
		System.out.println(new Date() +" Entering Method: " + joinpoint.getSignature().getName());
		Object[] args = joinpoint.getArgs();

		for (Object obj : args) {
			System.out.println("Arg : " + obj.getClass().getName() + " - " + obj.toString());
		}
	}
	
	@AfterThrowing("execution(* map.service.AdminUserService.*(..))")
	public void exceptionHandling(JoinPoint joinpoint) {
		System.out.println(new Date() +" Exception caused at Method: " + joinpoint.getSignature().getName());
		Object[] args = joinpoint.getArgs();
		for (Object obj : args) {
			System.out.println("Arg : " + obj.getClass() + " - " + obj.toString());
		}
	}
}
