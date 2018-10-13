package com.workshop.back.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogResponseTimeAspect {

    @Around("execution(* *(..)) && @annotation(LogResponseTime)")
    public Object around(final ProceedingJoinPoint joinPoint) throws Throwable {
        final Date start = new Date();
        final Object result = joinPoint.proceed();
        final Date end = new Date();
        log.info("Temps d'execution de la méthode = " + (end.getTime() - start.getTime()) + " ms");
        return result;
    }
}



