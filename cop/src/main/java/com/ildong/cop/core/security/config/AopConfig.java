package com.ildong.cop.core.security.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class AopConfig {
    @Around("execution(public void org.springframework.security.web.FilterChainProxy.doFilter(..))")
    public void handleRequestRejectedException(ProceedingJoinPoint joinPoint) throws Throwable{
        try {
            joinPoint.proceed();
        }
        catch (RequestRejectedException exception){
            HttpServletResponse response = (HttpServletResponse) joinPoint.getArgs()[1];
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
