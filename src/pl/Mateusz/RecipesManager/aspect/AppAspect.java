package pl.Mateusz.RecipesManager.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppAspect {

	// logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// pointcuts
	// match any class and any method in controller package
	@Pointcut("execution(* pl.Mateusz.RecipesManager.controller.*.*(..))")
	public void forControllerPackage() {
	}

	// match any class and any method in service package
	@Pointcut("execution(* pl.Mateusz.RecipesManager.service.*.*(..))")
	public void forServicePackage() {
	}

	// match any class and any method in dao package
	@Pointcut("execution(* pl.Mateusz.RecipesManager.dao.*.*(..))")
	public void forDaoPackage() {
	}
	
	//combine those pointcuts
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void complexPointcut() {
		
	}
	
	// @Before advice
	@Before("complexPointcut()")
	public void beforeAspect(JoinPoint joinPoint) {
	
		String theMethod = joinPoint.getSignature().toShortString();
		logger.info("\n -------------      using @Before aspect -> method called: "+theMethod);
		
		Object[] args = joinPoint.getArgs();
		for(Object e : args) {
			logger.info("\\n -------------  method argument: "+e);
		}
		
	}
	
	
	// @AfterReturning advice
	@AfterReturning(pointcut="complexPointcut()", 
			returning="result")
	public void afterAspect(JoinPoint joinPoint, Object result) {

		String theMethod = joinPoint.getSignature().toShortString();
		logger.info("\n -------------      using @AfterReturning aspect -> method called: "+theMethod);
		
		logger.info("\n ------------- result: "+result);
		
	}
	
	
}
