package com.qin;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
        initDegradeRule();
    }

    /**
     * API加载降级规则
     */
    private static void initDegradeRule() {
        List<DegradeRule> degradeRules = new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource("departList");
        //指定熔断策略为慢调用比例
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        //指定最大的RT
        degradeRule.setCount(2);
        //设定熔断时长
        degradeRule.setTimeWindow(5);
        //最小请求数
        degradeRule.setMinRequestAmount(3);
        //指定统计时长
        degradeRule.setStatIntervalMs(1000);
        //设置比例阈值
        degradeRule.setSlowRatioThreshold(0.2);
        degradeRules.add(degradeRule);
        DegradeRuleManager.loadRules(degradeRules);
    }
}
