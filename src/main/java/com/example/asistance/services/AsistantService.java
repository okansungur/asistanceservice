package com.example.asistance.services;

import com.example.asistance.clients.UserFeignClient;
import com.example.asistance.clients.UserRestTemplateClient;
import com.example.asistance.model.Asistant;
import com.example.asistance.model.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;

@Service
public class AsistantService {
    @Autowired
    UserFeignClient userFeignClient;
    @Autowired
    UserRestTemplateClient userRestTemplateClient;
    private static final Logger logger = LoggerFactory.getLogger(AsistantService.class);


    @CircuitBreaker(name = "asistantService", fallbackMethod = "buildFallbackAsistanceList")
    @RateLimiter(name = "asistantService", fallbackMethod = "buildFallbackAsistanceList")
    @Retry(name = "retryAsistantService", fallbackMethod = "buildFallbackAsistanceList")
    //@Bulkhead(name = "bulkheadAsistantService", type= Type.THREADPOOL, fallbackMethod = "buildFallbackAsistanceList")
    public List<Asistant> retrieveAsistantInfo() throws TimeoutException {
        Asistant myAsistant = null;
        List<Asistant> myemp = new ArrayList<>();
        Asistant emp = new Asistant(1001, "ayse", "London", 1);
        Asistant emp2 = new Asistant(2002, "fatma", "Paris", 2);
        myemp.add(emp);
        myemp.add(emp2);
        randomTimer();
        return myemp;
    }


    public User getFeignData(String userid) {
        User user = userFeignClient.getUser(userid);

        return user;
    }


    public User getRestData(String userid) {
        User user = userRestTemplateClient.getUser(userid);

        return user;
    }


    @SuppressWarnings("unused")
    private List<Asistant> buildFallbackAsistanceList(Throwable t) {
        List<Asistant> fallbackList = new ArrayList<>();
        Asistant demoasist = new Asistant();
        demoasist.setId(0);
        demoasist.setName("None");
        demoasist.setAddress("None");
        demoasist.setUserid(0);
        fallbackList.add(demoasist);
        return fallbackList;
    }


    private void randomTimer() throws TimeoutException {
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        if (randomNum == 3) sleep();
    }

    private void sleep() throws TimeoutException {
        try {
            System.out.println("Sleepy");
            Thread.sleep(5000);
            throw new java.util.concurrent.TimeoutException();
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}