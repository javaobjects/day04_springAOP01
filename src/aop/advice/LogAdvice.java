package aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 
* <p>Title: LogAdvice</p>  
* <p>
*	Description: 
*   切面(ascpet) = 切入点(pointCut) + 通知(advice)
*   
*   切入点(@Pointcut):修饰的方法不需要返回值，不需要参数，仅作为一个切入点的标记
*   
*   通知(advice)
*   	前置通知:@Before,在调用方法之前执行的代码
*   	后置通知:@AfterReturning修饰，在调用方法之后执行的代码
*   	环绕通知:@around修饰，在调用方法之前，以及方法调用完成之后会执行的代码
*   	抛出通知:@throwing修饰，在代码抛出异常时执行的代码
*   	最终通知:@After修饰，通常用于资源释放与资源关闭
* </p> 
* @author xianxian 
* @date 2019年10月14日
 */
@Aspect
public class LogAdvice {

	/**
	 * 
	 * <p>Title: method</p>  
	 * <p>
	 *	Description: 
	 * 	切入点(pointCut):修饰的方法不需要返回值，不需要参数，仅作为一个切入点的标记
	 * </p>
	 */
	@Pointcut("execution(* aop.*.select*(..)) || execution(* aop.*.insert*(..))")
	public void method() {}
	
	/**
	 * 
	 *  通知(advice);
	 */
	/**
	 * 
	 * <p>Title: logBefore</p>  
	 * <p>
	 *	Description: 
	 *  1. 前置通知: 在调用方法之前执行代码
	 * </p>
	 */
	@Before("method()")
	public void logBefore() {
		System.out.println("日志记录............................前置通知【调用方法之前执行的代码】，例如:权限控制................");
	}
	@Before("method() && args(param)")
	public void logBeforeWithParams(String param) {
		System.out.println("日志记录............................前置通知【调用方法之前执行的代码】，例如:权限控制................参数:" + param);
	}
	/**
	 * 
	 * <p>Title: logAfterReturning</p>  
	 * <p>
	 *	Description: 
	 *  2. 后置通知: 在调用方法之后执行的代码
	 * </p> 
	 * @param returnValue
	 */
	@AfterReturning(pointcut = "method()",returning = "returnValue")
	public void logAfterReturning(boolean returnValue) {
		System.out.println("日志记录............................后置通知【调用方法之后执行的代码】，例如:返回校验................返回值:" + returnValue);
	}
	
	/**
	 * 
	 * <p>Title: logAround</p>  
	 * <p>
	 *	Description: 
	 *  3. 环绕通知:在调用方法之前，与方法调用之后 需要执行的代码
	 * </p> 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("method()")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		
		//调用真正的方法
		Object returnValue;
		try {
			System.out.println("日志记录............................后置通知【调用方法之后执行的代码】，例如:返回校验................返回值:" );
			System.out.println("日志记录............................后置通知【调用方法之后执行的代码】，例如:返回校验................返回值:" );
			
			returnValue = pjp.proceed();
			return returnValue;
		} catch (Throwable e) {
			throw e;
		}
	}
	/**
	 * 
	 * <p>Title: logAterThrowing</p>  
	 * <p>
	 *	Description: 
	 *  4.抛出通知:在异常抛出之后需要执行的代码
	 * </p> 
	 * @param ex
	 */
	@AfterThrowing(pointcut = "method()" ,throwing = "ex")
	public void logAterThrowing(Exception ex) {
		System.out.println("日志记录....................................抛出通知【在异常抛出之后需要执行的代码】，"
				+ "例如：日志记录、发送邮件(短信)..........异常信息:" + ex.getMessage());
	}
	/**
	 * 
	 * <p>Title: logAfter</p>  
	 * <p>
	 *	Description: 
	 *  5. 最终通知:不论代码执行是否正常或出现异常
	 *  最终都需要执行的代码，类似于try{}catch{}
	 *  finally{}中的finally
	 * </p>
	 */
	@After("method()")
	public void logAfter() {
		System.out.println("日志记录...........................最终通知"
				+ "【不论代码执行是否正常或出现异常，最终都需要执行的代码】"
				+ "例如:释放资源..........");
	}
}
