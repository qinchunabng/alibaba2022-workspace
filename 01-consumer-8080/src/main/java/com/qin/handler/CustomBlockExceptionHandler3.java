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

/**
 * 重定向页面
 */
@Component
public class CustomBlockExceptionHandler3 implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String url = "";
        if(e instanceof FlowException){
            url = "https://jd.com";
        }else if(e instanceof DegradeException){
            url = "https://baidu.com";
        }else if(e instanceof SystemBlockException){
            url = "https://taobao.com";
        }else if(e instanceof ParamFlowException){
            url = "https://oracle.com";
        }else if(e instanceof AuthorityException){
            url = "https://sentinelguard.io";
        }
        httpServletResponse.sendRedirect(url);
    }
}
