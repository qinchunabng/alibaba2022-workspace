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

//@Component
public class CustomBlockExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        httpServletResponse.setStatus(429);

        Writer writer = httpServletResponse.getWriter();
        String msg = "Blocked by sentinel - ";
        if(e instanceof FlowException){
            msg += "Flow Exception";
        }else if(e instanceof DegradeException){
            msg += "Degrade Exception";
        }else if(e instanceof SystemBlockException){
            msg += "System Exception";
        }else if(e instanceof ParamFlowException){
            msg += "Param Flow Exception";
        }else if(e instanceof AuthorityException){
            msg += "Authority Exception";
            httpServletResponse.setStatus(401);
        }
        writer.write(msg);
        writer.flush();
        writer.close();
    }
}
