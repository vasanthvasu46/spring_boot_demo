package com.Employee.aop;


import com.Employee.CustomException.EmptyDBExceptionClass;
import com.Employee.CustomException.EmptyFieldException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.NoSuchElementException;

@Aspect
@Configuration
public class AspectConfig {

    private Logger log = LoggerFactory.getLogger(AspectConfig.class);

    @Before(value = "execution(* com.Employee.Controller.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint) {
        log.info("Executing : {}", joinPoint);
    }

    @After(value = "execution(* com.Employee.Controller.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint) {
        log.info("Completed executing : {}", joinPoint);
    }

    @Around(value = "execution(* com.Employee.Controller.*.*(..))")
    public Object logStatementAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object obj = joinPoint.proceed();
            return obj;
        } catch (NoSuchElementException e) {
            log.info("Execption occured while running: {}", joinPoint);
            log.info("Exception : {}", e.getMessage());
            throw new NoSuchElementException();
        } catch (EmptyDBExceptionClass e) {
            log.info("Exception Status Code : {}", e.getErrorCode());
            log.info("Exception Message : {}", e.getErrorMessage());
            throw new EmptyDBExceptionClass("No records found in DB");
        } catch (EmptyFieldException e) {
            log.info("Exception Status Code : {}", e.getErrorCode());
            log.info("Exception Message : {}", e.getErrorMessage());
            throw new EmptyFieldException();
        }

    }

    @AfterThrowing(value = "execution(* com.Employee.Controller.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("After throwing exception in method: {}", joinPoint);
    }

}