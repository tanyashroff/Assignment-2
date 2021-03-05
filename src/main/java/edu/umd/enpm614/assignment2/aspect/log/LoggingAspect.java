package edu.umd.enpm614.assignment2.aspect.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class LoggingAspect {
    @Around("within((edu.umd.enpm614.assignment2.services.Frontend*) ||(edu.umd.enpm614.assignment2.services.Middleware*) || (edu.umd.enpm614.assignment2.services.Persistance*)) && execution(public * *(..))")
    public Object methodCall(ProceedingJoinPoint joinPoint) throws Throwable{
        StringBuilder sb = new StringBuilder("Logging Aspect: ");
        Object value = joinPoint.proceed();
        sb.append(joinPoint.getTarget().getClass().getName())
                .append(".")
                .append(joinPoint.getSignature().getName());
        System.out.println(sb.toString());
        return value;
    }
}
