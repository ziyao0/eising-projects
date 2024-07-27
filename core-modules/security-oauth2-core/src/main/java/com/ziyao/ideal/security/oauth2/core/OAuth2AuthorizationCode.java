package com.ziyao.ideal.security.oauth2.core;

import java.time.Instant;

/**
 * @author ziyao zhang
 */
public class OAuth2AuthorizationCode extends AbstractOAuth2Token {

    /**
     * Constructs an {@code OAuth2AuthorizationCode} using the provided parameters.
     *
     * @param tokenValue the token value
     * @param issuedAt   the time at which the token was issued
     * @param expiresAt  the time at which the token expires
     */
    public OAuth2AuthorizationCode(String tokenValue, Instant issuedAt, Instant expiresAt) {
        super(tokenValue, issuedAt, expiresAt);
    }

}