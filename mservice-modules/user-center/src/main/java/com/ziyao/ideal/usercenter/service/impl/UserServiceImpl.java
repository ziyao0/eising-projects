package com.ziyao.ideal.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziyao.ideal.usercenter.domain.dto.UserDTO;
import com.ziyao.ideal.usercenter.domain.entity.User;
import com.ziyao.ideal.usercenter.repository.mapper.UserMapper;
import com.ziyao.ideal.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhangziyao
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> page(Page<User> page, UserDTO userDTO) {
        LambdaQueryWrapper<User> wrapper = userDTO.initWrapper();
        // to do 2023/5/6 默认排序字段 sort/sorted(默认是为ASC)值越小、越往前
        return userMapper.selectPage(page, wrapper);
    }

    @Override
    public User loadUserDetails(String accessKey) {
        // 通过appid和accessKey获取用户信息
        return userMapper.selectOne(
                Wrappers.lambdaQuery(User.class)
                        .eq(User::getUsername, accessKey));

    }
}
