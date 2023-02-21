package com.ragu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;



import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class Logging {
	Logger log = LoggerFactory.getLogger(Logging.class);

	@Before("execution(* com.ragu.service.*.*(..))")
	public Object applicationLogger(JoinPoint pjp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		log.info("Method Invoked" + className + " : " + methodName + "()" + "arguments"
				+ mapper.writeValueAsString(array));
		return array;
	}

	@After("execution(* com.ragu.service.*.*(..))")
	public void appLogger(JoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		log.info("Finished Executing classname:{}" + className + " Methodname:{}" + methodName);
	}

}
