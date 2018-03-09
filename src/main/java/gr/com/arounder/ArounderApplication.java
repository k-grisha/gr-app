package gr.com.arounder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ArounderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArounderApplication.class, args);
    }
}

