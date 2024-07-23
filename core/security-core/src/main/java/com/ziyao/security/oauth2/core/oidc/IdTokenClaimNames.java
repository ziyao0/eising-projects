package com.ziyao.security.oauth2.core.oidc;

/**
 * @author ziyao
 */
public final class IdTokenClaimNames {

    /**
     * {@code iss} - the Issuer identifier
     */
    public static final String ISS = "iss";

    /**
     * {@code sub} - the Subject identifier
     */
    public static final String SUB = "sub";

    /**
     * {@code aud} - the Audience(s) that the ID Token is intended for
     */
    public static final String AUD = "aud";

    /**
     * {@code exp} - the Expiration time on or after which the ID Token MUST NOT be
     * accepted
     */
    public static final String EXP = "exp";

    /**
     * {@code iat} - the time at which the ID Token was issued
     */
    public static final String IAT = "iat";

    /**
     * {@code auth_time} - the time when the End-User authentication occurred
     */
    public static final String AUTH_TIME = "auth_time";

    /**
     * {@code nonce} - a {@code String} value used to associate a Client session with an
     * ID Token, and to mitigate replay attacks.
     */
    public static final String NONCE = "nonce";

    /**
     * {@code acr} - the Authentication Context Class Reference
     */
    public static final String ACR = "acr";

    /**
     * {@code amr} - the Authentication Methods References
     */
    public static final String AMR = "amr";

    /**
     * {@code azp} - the Authorized party to which the ID Token was issued
     */
    public static final String AZP = "azp";

    /**
     * {@code at_hash} - the Access Token hash value
     */
    public static final String AT_HASH = "at_hash";

    /**
     * {@code c_hash} - the Authorization Code hash value
     */
    public static final String C_HASH = "c_hash";

    private IdTokenClaimNames() {
    }

}

