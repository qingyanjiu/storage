package stream.mokulive.storage.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

@Component
public class AccessCountMetrics implements MeterBinder {

    public Counter totalCount;
    public Counter errorCount;
//    public Timer responseLatency;


    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        this.totalCount = Counter.builder("access_count").tags("type","api")
                .description("total request counter of api").register(meterRegistry);
        this.errorCount = Counter.builder("error_count").tags("type","api")
                .description("response Error counter of api").register(meterRegistry);
//        this.responseLatency = Timer.builder("response_latency").tags("type","api")
//                .description("timer").register(meterRegistry);
    }
}
