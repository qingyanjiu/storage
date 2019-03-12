package stream.mokulive.storage.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
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

    private Counter totalCount;
    private Counter errorCount;

    @Autowired
    private MeterRegistry meterRegistry;

    @Pointcut("execution(* stream.mokulive.storage..*Controller.*(..))")
    public void prometheusMonitor(){}

    @Around(value = "prometheusMonitor()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Map result = new HashMap();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String url = request.getRequestURI();

        totalCount = Counter.builder("access_count").tags(new String[]{"type","api","url",url})
                .description("total request counter of api").register(meterRegistry);
        errorCount = Counter.builder("error_count").tags(new String[]{"type","api","url",url})
                .description("response Error counter of api").register(meterRegistry);

        //prometheus访问计数器+1
        totalCount.increment();
        try {
            result = (Map) proceedingJoinPoint.proceed();
            Utils.tagResult(result,true);
        } catch (Throwable throwable) {
            logger.error("promethues捕捉到请求出错 : " + proceedingJoinPoint.getTarget().getClass().getName()
                    + "." + proceedingJoinPoint.getSignature().getName());
            //prometheus错误计数器加一
            errorCount.increment();
        } finally {
        }
        return result;
    }
}
