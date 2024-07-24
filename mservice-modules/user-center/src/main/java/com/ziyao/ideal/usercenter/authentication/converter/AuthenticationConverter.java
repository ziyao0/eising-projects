package com.ziyao.ideal.usercenter.authentication.converter;

import com.ziyao.ideal.usercenter.request.AuthenticationRequest;
import com.ziyao.security.oauth2.core.Authentication;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author ziyao
 */
public interface AuthenticationConverter {


    Authentication convert(AuthenticationRequest request);

    Authentication convert(HttpServletRequest request);
}