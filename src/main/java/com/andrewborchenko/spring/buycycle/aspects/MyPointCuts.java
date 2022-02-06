package com.andrewborchenko.spring.buycycle.aspects;

import com.andrewborchenko.spring.buycycle.models.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyPointCuts {
    @Pointcut("execution(* com.andrewborchenko.spring.buycycle.services.*.*(..))")
    public void allMethodsServicePack() {}

}
