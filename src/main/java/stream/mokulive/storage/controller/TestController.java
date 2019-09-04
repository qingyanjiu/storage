/**
 * @author louisliu
 * for batch request test
 */

package stream.mokulive.storage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

@Controller
@RequestMapping("/batch")
public class TestController {

    private BlockingQueue<MyRequest> q = new LinkedBlockingQueue<>();
    private Map<String, MyRequest> all = new ConcurrentHashMap();

    @RequestMapping("")
    @ResponseBody
    public MyRequest testBatch(String id) throws ExecutionException, InterruptedException {
        MyRequest request = new MyRequest(id);
        CompletableFuture completableFuture = new CompletableFuture();
        request.setFt(completableFuture);
        q.add(request);
        return request.getFt().get();
    }

    @PostConstruct
    public void init() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(() -> {
            int size = q.size();
            if (q.size() == 0) {
                return;
            }
            List<MyRequest> requests = new ArrayList();
            for (int i = 0; i < size; i++) {
                MyRequest request = q.poll();
                requests.add(request);
            }
            query(requests);
            System.out.println("number:" + size + "result:" + all);

            requests.forEach(r -> {
                r.getFt().complete(all.get(r.getId()));
            });

        }, 0, 200, TimeUnit.MILLISECONDS);
    }

    private void query(List<MyRequest> requests) {
        requests.forEach(request -> {
            request.setName(UUID.randomUUID() + "---" + request.getId());
            all.put(request.getId(), request);
        });
    }

    class MyRequest {

        private CompletableFuture<MyRequest> ft;

        private String id;
        private String name;

        public MyRequest(String id) {
            this.id = id;
        }

        public CompletableFuture<MyRequest> getFt() {
            return ft;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setFt(CompletableFuture<MyRequest> ft) {
            this.ft = ft;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
