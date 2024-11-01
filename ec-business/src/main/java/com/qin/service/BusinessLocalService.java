package com.qin.service;

import org.apache.skywalking.apm.toolkit.trace.Trace;

public class BusinessLocalService {

    @Trace  //加上@Trace注解调用链路中就会显示改方法的调用
    public void info(){
        System.out.println("Auth:" + auth("Tom" + ".email" + email("Tom@163.com")));
    }

    @Trace
    private String email(String addr){
        return addr;
    }

    private String auth(String name){
        return name;
    }
}
