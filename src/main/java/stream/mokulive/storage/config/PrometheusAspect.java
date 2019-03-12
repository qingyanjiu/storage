package stream.mokulive.storage.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import stream.mokulive.storage.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class PrometheusAspect{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccessCountMetrics metrics;

    @Pointcut("execution(* stream.mokulive.storage..*Controller.*(..))")
    public void prometheusMonitor(){}

    @Around(value = "prometheusMonitor()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Map result = new HashMap();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String url = request.getRequestURI();
        //prometheus访问计数器+1
        metrics.totalCount.increment();
        try {
            result = (Map) proceedingJoinPoint.proceed();
            Utils.tagResult(result,true);
        } catch (Throwable throwable) {
            logger.error("promethues捕捉到请求出错 : " + proceedingJoinPoint.getTarget().getClass().getName()
                    + "." + proceedingJoinPoint.getSignature().getName());
            //prometheus错误计数器加一
            metrics.errorCount.increment();
        } finally {
        }
        return result;
    }
}
