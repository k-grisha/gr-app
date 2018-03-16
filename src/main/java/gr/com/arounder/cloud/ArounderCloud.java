package gr.com.arounder.cloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ArounderCloud {

    @GetMapping("/item")
    String getItem();

    @GetMapping("/around/{value}")
    String around(@PathVariable("value") String value);

    @GetMapping("/hash/{value}")
    int hash(@PathVariable("value") String value);

    @GetMapping("/fuck/")
    int fuck();
}
