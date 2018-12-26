package stream.mokulive.storage.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import stream.mokulive.storage.exception.DuplicateNameException;
import stream.mokulive.storage.utils.Utils;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ControllerLogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * stream.mokulive.storage.controller.*.*(..))")
    public void controllerLog(){}

    @Around(value = "controllerLog()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Map result = new HashMap();
        try {
            result = (Map) proceedingJoinPoint.proceed();
            Utils.tagResult(result,true);
        } catch (Throwable throwable) {
            result = handleException(
                    throwable,
                    proceedingJoinPoint,
                    result
            );
        }
        return result;
    }

    private Map handleException(Throwable throwable, ProceedingJoinPoint proceedingJoinPoint, Map result) {
        Class clazz = proceedingJoinPoint.getSignature().getDeclaringType();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Utils.tagResult((HashMap)result,false);
        if(throwable instanceof DuplicateNameException) {
            logger.error("添加记录时发生了重名异常 ********* " + clazz.getName() + "======" + methodName);
            result.put("msg","Duplicate name");
        }
        else {
            logger.error(throwable.getMessage() + " ********* " + clazz.getName() + "======" + methodName);
            result.put("msg",throwable.getMessage());
        }
        return result;
    }

}
