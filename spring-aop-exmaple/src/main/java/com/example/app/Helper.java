package com.example.app;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

// Advice-> What (you want to call) , type of advice (before , after)
// PointCut -> Where

@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper {

    // it will call before execution of show method
    @Before("execution(public void show())")
    public void log(){
        System.out.println("show called");
    }
    public static void security(){

    }
}
