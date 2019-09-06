package com.formation.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ComptePerf {
	@Before("execution(* com.formation.spring.service..*(..))")
	public void compteur(JoinPoint joinPoint){
		System.out.println("Interception : methode="+joinPoint.toString());
	}
	
	@Around("execution(* com.formation.spring.service..*(..))")
	public Object perf(ProceedingJoinPoint proceedingJoinPoint){
		
		//System.out.println("Before invoking service method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("temps d'execution de ="+proceedingJoinPoint.toString()+" = ");
		return value;
	}
}
