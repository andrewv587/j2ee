package com.hwh.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LogInterceptor {
	@Pointcut("execution(* com.hwh.dao..*.*(..))")
	public void bee(){};
	
	//@Before("bee()")
	public void before(){
		System.out.println("begin logging!");
	}
	
	//@AfterReturning("execution(* com.hwh.dao..*.*(..))") //只需要记住这一种
	public void after(){
		System.out.println("finish logging!");
	}
	
/*	 @AfterThrowing("execution(* com.hwh.dao..*.*(..))")
    public void doRecoveryActions() {
		 System.out.println("find exception!");
    }*/
	 
	//@Around("bee()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("method start!");
        Object retVal = pjp.proceed();
        System.out.println("method end!");
        return retVal;
    }
}
