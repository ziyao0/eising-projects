package com.ziyao.gateway.filter;

import com.ziyao.eis.core.metrics.StopWatch;
import com.ziyao.gateway.core.GatewayStopWatches;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * 秒表信息打印
 *
 * @author ziyao zhang
 */
@Slf4j
@Component
public class StopWatchFilter extends AbstractGlobalFilter {

    @Override
    protected Mono<Void> doFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // @formatter:off
        return chain.filter(exchange).doFinally(signalType -> {
            StopWatch stopWatch = GatewayStopWatches.getStopWatch(exchange);
            if (Objects.nonNull(stopWatch)){
                log.info(stopWatch.prettyPrint());
            }
        });
        // @formatter:on
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}