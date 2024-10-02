package com.qin.factory;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class TokenRoutePredicateFactory extends AbstractRoutePredicateFactory<TokenRoutePredicateFactory.Config> {

    public TokenRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            //获取请求中所有的请求参数
            MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();
            List<String> values = params.get("token");
            if(!CollectionUtils.isEmpty(values) || values.contains(config.getToken())){
                return true;
            }
            return false;
        };
    }

    static class Config {

        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("token");
    }
}
