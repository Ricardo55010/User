package com.example.user.Aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Before("execution(* com.example.user.Controller.*.*(..))")
    public void logBeforeMethodExecution() {
        System.out.println("Starting controller");
    }
    @After("execution(* com.example.user.Controller.*.*(..))")
    public void logAfterMethodExecution() {
        System.out.println("Ending controller");
    }
}
