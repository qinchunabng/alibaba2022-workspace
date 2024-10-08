package com.qin.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.qin.bean.Depart;
import com.qin.controller.api.ProviderApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RefreshScope
@RestController
@RequestMapping("/consumer/depart")
public class ConsumerController {

    private static final String URL = "http://depart-provider/provider/depart";

    private final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${depart.name:}")
    private String departName;

    @Autowired
    private ProviderApi providerApi;

    @PostMapping("")
    public boolean save(@RequestBody Depart depart){
        return restTemplate.postForObject(URL, depart, Boolean.class);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        restTemplate.delete(URL + "/" + id);
        return true;
    }

    @PutMapping("")
    public boolean update(@RequestBody Depart depart){
        restTemplate.put(URL, depart);
        return true;
    }

    @GetMapping("/{id}")
    public Depart get(@PathVariable Integer id){
//        return restTemplate.getForObject(URL + "/" + id, Depart.class);
        return providerApi.get(id);
    }


    @GetMapping("/list")
    public List<Depart> list(@RequestHeader String color){
//        return restTemplate.getForObject(URL + "/list", List.class);
        logger.info("header -> color: {}", color);
        return providerApi.list();
    }

    @GetMapping("/services")
    public List<String> services(){
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            logger.info("{}", instances);
        }
        return services;
    }

    @GetMapping("/name")
    public String getDepartName(){
        try {
            TimeUnit.MICROSECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return departName;
    }
}
