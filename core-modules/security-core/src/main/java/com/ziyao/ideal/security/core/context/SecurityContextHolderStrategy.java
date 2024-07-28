package com.ziyao.ideal.security.core.context;

import java.util.function.Supplier;

/**
 * @author ziyao zhang
 */
public interface SecurityContextHolderStrategy {

    /**
     * 清理当前上下文
     */
    void clearContext();


    AuthenticationContext getContext();


    default Supplier<AuthenticationContext> getDeferredContext() {
        return this::getContext;
    }


    void setContext(AuthenticationContext context);


    default void setDeferredContext(Supplier<AuthenticationContext> deferredContext) {
        setContext(deferredContext.get());
    }

    AuthenticationContext createEmptyContext();

    default boolean isAuthentication() {
        if (getContext() != null) {
            return getContext().getAuthentication().isAuthenticated();
        } else {
            return false;
        }
    }
}
