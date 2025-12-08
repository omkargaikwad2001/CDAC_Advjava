package entities;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Logger {

    // Pointcut → target method
    @Pointcut("execution(* entities.Emp.toString(..))")
    public void selectToString() {}

    //  Before Advice — runs before the business logic
//    @Before("selectToString()")
//    public void beforemsg() {
//        System.out.println("Before Method");
//    }
    
    @Before("selectToString()")
    public void beforeMsg(JoinPoint jp) {
        System.out.println("🔥 Before Method -> " + jp.getSignature().getName());
    }

    //  After Advice — runs after method completes
    @After("selectToString()")
    public void afterMsg(JoinPoint jp) {
        System.out.println("✅ After Method -> " + jp.getSignature().getName());
    }

    // After Returning — only runs if method returns normally
    @AfterReturning(pointcut = "selectToString()", returning = "result")
    public void afterReturningMsg(Object result) {
        System.out.println("🎯 After Returning -> Result: " + result);
    }

    //  After Throwing — runs only if an exception occurs
    @AfterThrowing(pointcut = "selectToString()", throwing = "ex")
    public void afterThrowingMsg(Exception ex) {
        System.out.println("❌ Exception Thrown -> " + ex.getMessage());
    }

    // Around Advice — complete control: before + method call + after
    @Around("selectToString()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("⏳ Around -> Before calling method");

        Object result = pjp.proceed();  // actual method call

        System.out.println("⏱️ Around -> After calling method");

        return result;
    }
}
