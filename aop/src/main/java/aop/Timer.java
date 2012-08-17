package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Timer {
	private static long time = 0;

	@Pointcut("execution(* *.run(..))")
	public void perform() {
	}

	@Around("perform()")
	public Object timing(ProceedingJoinPoint joinPoint) {
		try {
			// start timing
			System.out.println("Timer start");
			time = System.currentTimeMillis();

			Object returnObject = joinPoint.proceed();

			// end timing
			time = System.currentTimeMillis() - time;
			System.out.println("Timer end");

			// report time
			System.out.println("Time used: " + time + " ms.");

			return returnObject;
		} catch (Throwable e) {
			System.out.println("match aborted");
			return null;
		}
	}
}
