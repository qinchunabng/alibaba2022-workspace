package com.qin.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.qin.bean.Depart;
import com.qin.service.DepartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/provider/depart")
@RestController
public class DepartController {

    private final Logger logger = LoggerFactory.getLogger(DepartController.class);

    @Autowired
    private DepartService departService;

    @PostMapping("")
    public boolean save(@RequestBody Depart depart){
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return departService.removeDepartById(id);
    }

    @PutMapping("")
    public boolean update(@RequestBody Depart depart){
        return departService.modifyDepart(depart);
    }

    @GetMapping("/{id}")
    public Depart get(@PathVariable Integer id){
        return departService.getDepartById(id);
    }

    @SentinelResource(value = "departList", fallback = "listFallback")
    @GetMapping("/list")
    public List<Depart> list(){
        return departService.listAllDeparts();
    }

    public List<Depart> listFallback(Throwable t){
        logger.error("发生异常", t);
        return new ArrayList<>();
    }
}
