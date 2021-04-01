package com.kunghsuspringcloud.eurekaclienttwo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/two")
@RestController
public class HelloController {

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/testHello")
    public String testHello(){

        try {
            //睡眠一秒
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("kunghsu in two...");
        return "kunghsu";
    }

    @RequestMapping("/testHello2")
    public String testHello2(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("kunghsu in two...");
        return "kunghsu";
    }


    @RequestMapping("/testHello3")
    public String testHello3(){

        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                //请求
                restTemplate.getForObject("http://localhost:8080/hystrix/test4", String.class);
            }).start();
        }

        System.out.println("kunghsu in testHello3...");
        return "kunghsu";
    }


}
