package com.ziyao.ideal.web;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 * @author zhangziyao
 */
@Data
@Builder
public class UserDetails implements Serializable {
    @Serial
    private static final long serialVersionUID = 8891009175629512495L;

    private Long appid;

    private Long userId;

    private String username;

    private String nickname;

    private String phone;

    private String email;

    private Long deptId;

    private String deptName;

    private Map<String, Object> additionalInformation;
}
