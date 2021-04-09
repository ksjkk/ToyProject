package com.ildong.demo.global.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    private static final Logger logger = LoggerFactory.getLogger(TimeTraceAop.class);

    @Around("execution (* com.ildong.demo.domain..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        logger.debug("START : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        }
        finally {
            long timeMs = System.currentTimeMillis() - start;
            logger.debug("END : " + joinPoint.toString() + " " + timeMs +"ms");
        }
    }
}
