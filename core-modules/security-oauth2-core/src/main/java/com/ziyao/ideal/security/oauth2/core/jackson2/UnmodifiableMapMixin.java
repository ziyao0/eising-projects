package com.ziyao.ideal.security.oauth2.core.jackson2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

/**
 * @author ziyao zhang
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonDeserialize(using = UnmodifiableMapDeserializer.class)
abstract class UnmodifiableMapMixin {

    @JsonCreator
    UnmodifiableMapMixin(Map<?, ?> map) {
    }

}
