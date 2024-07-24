package com.ziyao.ideal.gateway.filter.intercept;

import com.ziyao.ideal.core.Assert;
import com.ziyao.ideal.gateway.core.Interceptor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ziyao zhang
 */
@Getter
public class DelegatingInterceptor implements Interceptor<InterceptContext> {

    private final List<Interceptor<InterceptContext>> interceptors;

    @SafeVarargs
    public DelegatingInterceptor(Interceptor<? extends InterceptContext>... interceptors) {
        Assert.notNull(interceptors, "interceptors cannot be empty");
        Assert.noNullElements(interceptors, "interceptors cannot be null");
        this.interceptors = List.copyOf(asList(interceptors));
    }

    @Override
    public void intercept(InterceptContext context) {
        for (Interceptor<InterceptContext> interceptor : getInterceptors()) {
            interceptor.intercept(context);
        }
    }


    @SuppressWarnings("unchecked")
    private List<Interceptor<InterceptContext>> asList(
            Interceptor<? extends InterceptContext>... interceptors) {

        List<Interceptor<InterceptContext>> interceptorList = new ArrayList<>();
        for (Interceptor<? extends InterceptContext> interceptor : interceptors) {
            interceptorList.add((Interceptor<InterceptContext>) interceptor);
        }
        return interceptorList.stream()
                .sorted(Comparator.comparing(Interceptor::getOrder))
                .collect(Collectors.toList());
    }
}
