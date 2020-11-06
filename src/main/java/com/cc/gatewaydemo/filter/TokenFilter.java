package com.cc.gatewaydemo.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class TokenFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        boolean flag = StringUtils.isEmpty(exchange.getRequest().getHeaders().getFirst("token"));
        if(flag){
            String token = "tokenTest";
            ServerHttpRequest request = exchange.getRequest().mutate().header("mytoken",token).build();
            return chain.filter(exchange.mutate().request(request).build());
        }else{
            ServerHttpRequest request = exchange.getRequest().mutate().header("mytoken",exchange.getRequest().getHeaders().getFirst("token")).build();
            return chain.filter(exchange);
        }
    }

    @Override
    public int getOrder() {
        return -99;
    }
}
