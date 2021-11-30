package com.example.asistance.clients;

import com.example.asistance.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRestTemplateClient {

    @Autowired
    RestTemplate restTemplate;

    public User getUser(String userid) {
        ResponseEntity<User> restExchange =
                restTemplate.exchange(
                        "http://userservice/myredis/getUser/{userId}",
                        HttpMethod.GET,
                        null, User.class, userid);

        return restExchange.getBody();
    }

}
