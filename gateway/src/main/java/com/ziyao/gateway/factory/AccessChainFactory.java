package com.ziyao.gateway.factory;

import com.ziyao.eis.core.Collections;
import com.ziyao.gateway.core.token.DefaultAccessToken;
import com.ziyao.gateway.factory.chain.AbstractSecurityHandler;
import com.ziyao.gateway.support.ApplicationContextUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author ziyao
 */
@Component
public class AccessChainFactory extends AbstractFactory<DefaultAccessToken> {


    private AbstractSecurityHandler abstractSecurityHandler;


    public void filter(DefaultAccessToken defaultAccessToken) {
        abstractSecurityHandler.handle(defaultAccessToken);
    }


    @PostConstruct
    @Override
    protected void init() {
        List<AbstractSecurityHandler> abstractSecurityHandlers = ApplicationContextUtils.getBeansOfType(AbstractSecurityHandler.class);
        if (!Collections.isEmpty(abstractSecurityHandlers)) {
            abstractSecurityHandlers.stream().sorted(Comparator.comparing(AbstractSecurityHandler::getOrder))
                    .forEach(abstractSecurityHandler -> {
                                if (Objects.isNull(this.abstractSecurityHandler)) {
                                    this.abstractSecurityHandler = abstractSecurityHandler;
                                } else {
                                    this.abstractSecurityHandler.linkWith(abstractSecurityHandler);
                                }
                            }
                    );
        }
    }
}
