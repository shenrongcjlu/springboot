package com.itmayiedu.member.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
@Aspect
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.itmayiedu.member.controller.*.*(..))")
    public void weblog() {

    }

    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URL:" + request.getRequestURL());
        logger.info("method:" + request.getMethod());
        logger.info("IP:" + request.getRemoteAddr());

        Enumeration<String> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String name = enums.nextElement();
            logger.info("name:{},value{}", name, request.getParameter(name));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "weblog()")
     public  void doAfterReturning(Object ret) {
        logger.info("Response:" + ret);
    }

}
