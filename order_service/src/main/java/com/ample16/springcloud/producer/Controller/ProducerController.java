package com.ample16.springcloud.producer.Controller;

import com.ample16.springcloud.producer.client.ConsumerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    public ConsumerClient consumerClient;
    @GetMapping("/produce")
    public HashMap produce() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "kaka");
        map.put("age", 18);
//        consumerClient.testCallConsumer();
        consumerClient.testFallBackMethod();
        return map;
    }
}
