package gr.com.arounder.controller;

import gr.com.arounder.cloud.ArounderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    ArounderClient arounderClient;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello my dear " + arounderClient.around(name);
//        return "Hello my dear " + name;
    }
}