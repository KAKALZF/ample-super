package com.ample16.springcloud.producer.client;

import com.ample16.springcloud.producer.callback.FeignFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "USER-SERVICE",fallback = FeignFallBack.class)
public interface ConsumerClient {
    @GetMapping("/user/userInfo")
    void testCallConsumer();

    @GetMapping("/user/fallBackMethod")
    void testFallBackMethod();
}
