package stream.mokulive.storage.config;

import io.prometheus.client.Counter;
import io.prometheus.client.Histogram;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Counter accessCount = Counter.build().name("access_count").labelNames("api").help
            ("total request counter of api").register();
    private static final Counter errorCount = Counter.build().name("error_count").labelNames("api").help
            ("response Error counter of api").register();
    private static final Histogram responseLatency = Histogram.build().name("response_latency").labelNames("api").help
            ("response latency of api").register();

    @Pointcut("execution(* stream.mokulive.storage..*Controller.*(..))")
    public void prometheusMonitor(){}

    @Around(value = "prometheusMonitor()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Map result = new HashMap();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String url = request.getRequestURI();
        //prometheus访问计数器+1
        accessCount.labels(url).inc();
        //响应延迟直方图开始计时
        Histogram.Timer timer = responseLatency.labels(url).startTimer();
        try {
            result = (Map) proceedingJoinPoint.proceed();
            Utils.tagResult(result,true);
        } catch (Throwable throwable) {
            logger.error("promethues捕捉到请求出错 : " + proceedingJoinPoint.getTarget().getClass().getName()
                    + "." + proceedingJoinPoint.getSignature().getName());
            //prometheus错误计数器加一
            errorCount.labels(url).inc();
        } finally {
            //响应延迟直方图计算时间
            timer.observeDuration();
        }
        return result;
    }
}
