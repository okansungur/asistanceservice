package com.example.asistance.clients;

import com.example.asistance.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("userservice")
public interface UserFeignClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/myredis/getUser/{userId}",
            consumes = "application/json")
    User getUser(@PathVariable("userId") String userid);
}
