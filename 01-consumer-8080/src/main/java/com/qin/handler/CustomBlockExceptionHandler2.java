package com.qin.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.Writer;

/**
 * 自定跳转页面
 */
//@Component
public class CustomBlockExceptionHandler2 implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String page = "";
        if(e instanceof FlowException){
            page = "/flow.html";
        }else if(e instanceof DegradeException){
            page = "/degrade.html";
        }else if(e instanceof SystemBlockException){
            page = "/degrade.html";
        }else if(e instanceof ParamFlowException){
            page = "/param.html";
        }else if(e instanceof AuthorityException){
            page = "/authority.html";
        }
        httpServletRequest.getRequestDispatcher(page).forward(httpServletRequest, httpServletResponse);
    }
}
