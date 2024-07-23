package com.ziyao.harbor.usercenter.authentication;

import com.ziyao.harbor.usercenter.authentication.processors.AuthenticationPostProcessor;
import com.ziyao.harbor.usercenter.authentication.strategy.AuthenticationStrategyManager;
import com.ziyao.harbor.usercenter.authentication.token.FailureAuthentication;
import com.ziyao.security.oauth2.core.Authentication;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

/**
 * @author ziyao zhang
 */
@RequiredArgsConstructor
public class DefaultAuthenticationHandler implements AuthenticationHandler {

    private static final Logger log = LoggerFactory.getLogger(DefaultAuthenticationHandler.class);

    private final AuthenticationPostProcessor delegatingPostProcessor;
    private final AuthenticationStrategyManager authenticationStrategyManager;

    @Override
    public Authentication onSuccessful(Authentication authentication) {
        // 登录成功后触发
        try {
            return delegatingPostProcessor.process(authentication);
        } catch (Exception ex) {
            log.error("执行认证后置处理器异常：{}", ex.getMessage(), ex);
            return this.onFailure(authentication, ex);
        }
    }

    @Override
    public Authentication onFailure(Authentication authentication, @Nullable Exception ex) {

        try {
            Authentication handled = authenticationStrategyManager.handle(authentication, ex);
            if (handled != null) {
                return handled;
            }
        } catch (Exception e) {
            Authentication handled = authenticationStrategyManager.handle(authentication, e);
            if (handled != null) {
                return handled;
            }
        }
        // 认证失败后触发
        return FailureAuthentication.of(500, "");
    }
}