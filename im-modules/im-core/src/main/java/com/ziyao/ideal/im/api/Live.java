package com.ziyao.ideal.im.api;

/**
 * @author ziyao zhang
 */
public enum Live {
    /**
     * {@code PING} IN LIVE,
     * Heartbeat detection initiated by the client to the server
     */
    PING,

    /**
     * {@code PONG} IN LIVE,
     * The server responds to the server after receiving the client's heartbeat detection
     */
    PONG,

    /**
     * {@code FAIL} IN LIVE,Failure mark
     */
    FAIL,

    /**
     * {@code SUCCESS} IN LIVE,Success mark
     */
    SUCCESS;
}
