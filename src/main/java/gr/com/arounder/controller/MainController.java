package gr.com.arounder.controller;


import gr.com.arounder.cloud.ArounderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private static Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private ArounderClient arounderClient;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        LOGGER.warn("hello controller with PathVariable =" + name);
//        int hash = arounderClient.hash(name);
        String item = arounderClient.getItem();
        String roundName = arounderClient.around(name);
        Integer hash = arounderClient.hash(name);
//        arounderClient.fuck();
        return "Your name will be surrounded by " + item + "\n" + roundName + "\nand hash of the name is " + hash;
    }

    @GetMapping("/fuck")
    public void fuck() {
        arounderClient.fuck();
    }
}
