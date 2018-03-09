package gr.com.arounder.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "gr-arounder", fallback = ArounderClient.ArounderClientFallBack.class)
public interface ArounderClient extends ArounderCloud {

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
