package com.ziyao.ideal.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziyao.ideal.usercenter.domain.dto.RoleDTO;
import com.ziyao.ideal.usercenter.domain.entity.Role;
import com.ziyao.ideal.usercenter.repository.mapper.RoleMapper;
import com.ziyao.ideal.usercenter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author zhangziyao
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Page<Role> page(Page<Role> page, RoleDTO roleDTO) {
        LambdaQueryWrapper<Role> wrapper = roleDTO.initWrapper();
        // to do 2023/5/6 默认排序字段 sort/sorted(默认是为ASC)值越小、越往前
        return roleMapper.selectPage(page, wrapper);
    }
}
