package com.ziyao.ideal.usercenter.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ziyao.ideal.usercenter.dto.RoleDTO;
import com.ziyao.ideal.usercenter.entity.Role;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author zhangziyao
 */
public interface RoleService extends IService<Role> {

    /**
     * 分页查询
     */
    Page<Role> page(Page<Role> page, RoleDTO roleDTO);
}