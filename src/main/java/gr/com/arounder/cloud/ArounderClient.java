package gr.com.arounder.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "gr-arounder", fallback = ArounderClient.ArounderClientFallBack.class)
public interface ArounderClient extends ArounderCloud {

    @Component
    class ArounderClientFallBack implements ArounderClient {

        @Override
        public String getItem() {
            return "-";
        }

        @Override
        public String around(String value) {
            return "-" + value + "-";
        }
    }
}
