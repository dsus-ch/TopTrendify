package com.thehanged.gateway.app.filter;

import com.thehanged.utils.common.AppJwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class AuthorityFilter implements Ordered, GlobalFilter {
    /**
     * @param exchange 
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        if(request.getURI().getPath().contains("login")){
            return chain.filter(exchange);
        }

        // 获取token
        String token = request.getHeaders().getFirst("token");
        log.info("===================token:{}", token);

        if(StringUtils.isNoneBlank(token)){
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        // 校验token
        try{
            Claims claims = AppJwtUtil.getClaimsBody(token);
            int res = AppJwtUtil.verifyToken(claims);
            if(res == 1 || res == 2){
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }
        }catch (Exception e){
            log.info(e.getMessage());
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }

    /**
     * 过滤器的优先级
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
