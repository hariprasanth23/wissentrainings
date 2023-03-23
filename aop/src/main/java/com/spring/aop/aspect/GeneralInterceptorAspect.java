package com.spring.aop.aspect;

import com.spring.aop.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {

    //@Pointcut("@annotation(com.spring.aop.aspect.CustomAnnotation)")
    @Pointcut("execution(* com.spring.aop.controller.*.*(..) )")
    public void loggingPointCut(){
    }



    @Before("loggingPointCut()")
    public void before(JoinPoint joinPoint){
        log.info("Before method invoked::" + joinPoint.getSignature());
    }

    @After("loggingPointCut()")
    public void after(JoinPoint joinPoint){
        log.info("After method invoked::" + joinPoint.getSignature());
    }




    /*

    @AfterReturning(value = "execution(* com.spring.aop.controller.*.*(..) )",
            returning = "employee")
    public void afterReturning (JoinPoint joinPoint , Employee employee){
        log.info(" after returning ::" + employee);
    }

    @AfterThrowing(value = "execution(* com.spring.aop.controller.*.*(..) )",
            throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        log.info(" after throwing::" + e.getMessage());
    }


     */

    /*
    @Around("loggingPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around method invoked::"+joinPoint.getSignature());
        Object object = joinPoint.proceed();

        log.info("After method invoked.."+joinPoint.getSignature());
        return object;
    }


     */

}
