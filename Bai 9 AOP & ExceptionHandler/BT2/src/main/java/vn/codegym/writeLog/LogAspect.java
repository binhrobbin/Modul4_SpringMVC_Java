package vn.codegym.writeLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* vn.codegym.controller.BookController.showBook(..))")
    public void allMethodPointCut(){}

    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint){
        //ghi log - log4J
        System.out.println("Start method name: "
                + joinPoint.getSignature().getName()
                + " Time: "+ LocalDateTime.now());
    }
}
