package com.qin.controller.api;

import com.qin.bean.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "depart-provider", path="/provider/depart")
public interface ProviderApi {

    @GetMapping("/list")
    List<Depart> list();

    @GetMapping("/{id}")
    Depart get(@PathVariable("id") Integer id);
}
