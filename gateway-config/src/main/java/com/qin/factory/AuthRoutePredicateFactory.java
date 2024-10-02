package com.qin.factory;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class AuthRoutePredicateFactory extends AbstractRoutePredicateFactory<AuthRoutePredicateFactory.Config> {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public AuthRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            //获取所有的请求头
            HttpHeaders headers = exchange.getRequest().getHeaders();
            List<String> passwds = headers.get(config.getUsername());
            if(!CollectionUtils.isEmpty(passwds) && passwds.contains(config.getPassword())){
                return true;
            }
            return false;
        };
    }

    public static class Config {

        private String username;

        private String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    @Override
    public List<String> shortcutFieldOrder() {
        //指定参数的config参数顺序
        return Arrays.asList("username", "password") ;
    }
}
