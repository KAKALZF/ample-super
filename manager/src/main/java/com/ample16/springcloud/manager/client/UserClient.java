package com.ample16.springcloud.manager.client;

import com.ample16.common.Response;
import com.ample16.common.entity.User;
import com.ample16.common.req.user.LoginReq;
import com.ample16.common.req.user.RegisterReq;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("USER-SERVICE")
public interface UserClient {
    @GetMapping(value = "/user/findByName")
    //Get方式的话参数要贴标签，不然请求报错
    Response<User> findByName(@RequestParam("name") String name);

    @PostMapping("/user/register")
    Response register(@RequestBody RegisterReq registerReq);
}
