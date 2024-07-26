package com.ziyao.ideal.web;

import com.ziyao.ideal.core.Strings;

import java.util.Objects;

/**
 * @author zhangziyao
 */
public abstract class ContextUtils {

    private ContextUtils() {
    }

    public static boolean isLegal(UserDetails userDetails) {
        return Objects.nonNull(userDetails) && Strings.hasLength(userDetails.getUsername());
    }
}