package com.ziyao.ideal.usercenter.domain.dto;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ziyao.ideal.web.orm.EntityDTO;
import com.ziyao.ideal.usercenter.domain.entity.RoleMenu;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author zhangziyao
 */
@Data
public class RoleMenuDTO implements EntityDTO<RoleMenu>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统id
     */
    private Long appId;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 菜单id
     */
    private Long menuId;
    /**
     * 创建人id
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 组装查询条件，可根据具体情况做出修改
     *
     * @see LambdaQueryWrapper
     */
    public LambdaQueryWrapper<RoleMenu> initWrapper() {

        return Wrappers.lambdaQuery(RoleMenu.class)
                ;
    }

    @Override
    public RoleMenu getEntity() {
        return new RoleMenu();
    }
}
