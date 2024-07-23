package com.ziyao.gateway.filter.intercept;

import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * @author ziyao zhang
 */
public interface InterceptContext {

    /**
     * 访问ip
     *
     * @return {@link ServerHttpRequest#getURI()}
     * @see org.springframework.web.server.ServerWebExchange
     */
    String accessIP();

    /**
     * 访问资源
     *
     * @return {@link ServerHttpRequest#getPath()}
     * @see org.springframework.web.server.ServerWebExchange
     */
    String accessResource();

    /**
     * 访问域
     *
     * @return {@link ServerHttpRequest#getRemoteAddress()}
     * @see org.springframework.web.server.ServerWebExchange
     */
    String domain();
}
