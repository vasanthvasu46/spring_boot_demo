package com.employeeee.aop;


import com.employeeee.customexception.EmptyDBException;
import com.employeeee.customexception.EmptyFieldException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.NoSuchElementException;

@Aspect
@Configuration
public class AspectConfig {

    private Logger log = LoggerFactory.getLogger(AspectConfig.class);

    @Before(value = "execution(* com.employee.controller.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint) {
        log.info("Executing : {}", joinPoint);
    }

    @After(value = "execution(* com.employee.controller.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint) {
        log.info("Completed executing : {}", joinPoint);
    }

    @Around(value = "execution(* com.employee.controller.*.*(..))")
    public Object logStatementAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object obj = joinPoint.proceed();
            return obj;
        } catch (NoSuchElementException e) {
            log.error("Exception while running: {}", joinPoint);
            log.error("Exception : {}", e.getMessage());
            throw new NoSuchElementException(e.getMessage());
        } catch (EmptyDBException e) {
            log.error("Exception Status Code : {}", e.getErrorCode());
            log.error("Exception Message : {}", e.getErrorMessage());
            throw new EmptyDBException(e.getErrorMessage());
        } catch (EmptyFieldException e) {
            log.error("Exception Status Code : {}", e.getErrorCode());
            log.error("Exception Message : {}", e.getErrorMessage());
            throw new EmptyFieldException(e.getErrorMessage());
        }

    }

    @AfterThrowing(value = "execution(* com.employee.controller.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint) {
        log.info("After throwing exception in method: {}", joinPoint);
    }

}
