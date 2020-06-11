package com.dilipmaharjan.aop.aspect;

import javax.naming.spi.DirStateFactory.Result;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ServiceAspect {

	@Pointcut("execution(* com.dilipmaharjan.aop.service.CustomerService.*(..))")
	public void logCustomerService() {

	}

	@Pointcut("execution(* com.dilipmaharjan.aop.controller.CustomerController.*(..))")
	public void logController() {

	}

	@Before("logCustomerService() || logController()")
	public void before(JoinPoint jp) {
		MethodSignature methodSignature = (MethodSignature) jp.getSignature();
		String methodName = methodSignature.getMethod().getName();
		log.info("Method invoked before>>>>> " + methodName + System.currentTimeMillis());
		for (Object o : jp.getArgs()) {
			log.info("Args :  " + o);
		}

	}

	@After("logCustomerService()" +  "logController()")
	public void after(JoinPoint jp) {
		MethodSignature methodSignature = (MethodSignature) jp.getSignature();
		String methodName = methodSignature.getMethod().getName();
		log.info("Method invoked after>>>>> " + methodName + System.currentTimeMillis());
	}
	
//	@AfterReturning(pointcut = "logCustomerService()",returning = "result")
//	public void afterReturn(JoinPoint jp,Result result) {
//		MethodSignature methodSignature = (MethodSignature) jp.getSignature();
//		String methodName = methodSignature.getMethod().getName();
//		log.info("Method invoked afterReturn>>>>> " + methodName + System.currentTimeMillis() +  "result  : " + result);
//	}
	
}
