package gr.com.arounder.cloud;


import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Primary
@FeignClient(name = "gr-arounder", fallbackFactory = ArounderClientFactoryFallBack.class)
//@HystrixProperty(name = "hystrix.command.default.execution.timeout.enabled", value = "false")
public interface ArounderClient {
    @GetMapping("/item")
    String getItem();

    @GetMapping("/around/{value}")
    String around(@PathVariable("value") String value);

    @GetMapping("/hash/{value}")
    int hash(@PathVariable("value") String value);

    @GetMapping("/fuck/")
    int fuck();
}

//@Component
class ArounderClientFallBack implements ArounderClient {
    private static Logger LOGGER = LoggerFactory.getLogger(ArounderClientFallBack.class);

    @Override
    public String getItem() {
        LOGGER.warn("Arrounder fallback getItem");
        return "-";
    }

    @Override
    public String around(String value) {
        LOGGER.warn("Arrounder fallback Around " + value);
        return "-" + value + "-";
    }

    @Override
    public int hash(String value) {
        LOGGER.warn("Arrounder fallback hash " + value);
        return 0;
    }

    @Override
    public int fuck() {
        LOGGER.warn("Arrounder fallback fuck ");
        return 0;
    }
}


@Component
class ArounderClientFactoryFallBack implements FallbackFactory<ArounderClient> {

    private static Logger LOGGER = LoggerFactory.getLogger(ArounderClientFactoryFallBack.class);


    @Override
    public ArounderClient create(Throwable throwable) {
        if (throwable.getMessage() == null) {
            LOGGER.warn("Zapusk!!!", throwable);
        } else {
            LOGGER.warn(" FallBack reason is: " + throwable.getMessage(), throwable);
        }

        return new ArounderClient() {
            @Override
            public String getItem() {
                LOGGER.warn("Arrounder fallback getItem");
                return "-";
            }

            @Override
            public String around(String value) {
                LOGGER.warn("Arrounder fallback Around " + value);
                return "-" + value + "-";
            }

            @Override
            public int hash(String value) {
                LOGGER.warn("Arrounder fallback hash " + value);
                return 0;
            }

            @Override
            public int fuck() {
                LOGGER.warn("Arrounder fallback fuck ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 999;
            }
        };
    }
}