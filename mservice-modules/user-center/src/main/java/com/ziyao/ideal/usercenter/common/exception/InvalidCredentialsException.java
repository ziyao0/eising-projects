package com.ziyao.ideal.usercenter.common.exception;

import com.ziyao.security.oauth2.core.AuthenticationException;

import java.io.Serial;

/**
 * @author ziyao zhang
 */
public class InvalidCredentialsException extends AuthenticationException {

    @Serial
    private static final long serialVersionUID = 7363220172525003980L;

    public InvalidCredentialsException(String message) {
        super(message);
    }
}