package com.ziyao.harbor.usercenter.service.user;

import com.ziyao.eis.core.lang.Nullable;
import com.ziyao.security.oauth2.core.UserDetails;

/**
 * @author ziyao
 */
public interface UserDetailsService {

    /**
     * 通过用户名获取用户信息
     *
     * @param username 用户登陆名
     * @return 返回用户信息
     */
    @Nullable
    UserDetails loadUserByUsername(String username);

}
