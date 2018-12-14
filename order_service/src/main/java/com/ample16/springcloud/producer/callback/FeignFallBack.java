package com.ample16.springcloud.producer.callback;

import com.ample16.springcloud.producer.client.ConsumerClient;
import org.springframework.stereotype.Component;

@Component
public class FeignFallBack implements ConsumerClient {

    @Override
    public void testCallConsumer() {
        System.out.println("调用失败,使用容错方法1...");
    }

    @Override
    public void testFallBackMethod() {
        System.out.println("调用失败,使用容错方法2...");
    }
}
