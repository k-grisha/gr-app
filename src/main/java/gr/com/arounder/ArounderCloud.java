package gr.com.arounder;

import org.springframework.web.bind.annotation.GetMapping;

public interface ArounderCloud {

    @GetMapping("/item")
    String getItem();

    @GetMapping("/around/{value}")
    String around(String value);
}
