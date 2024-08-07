package com.ziyao.ideal.uua.controllers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ziyao.ideal.web.base.BaseController;
import com.ziyao.ideal.web.base.PageParams;
import com.ziyao.ideal.web.base.Pages;
import com.ziyao.ideal.web.exception.Exceptions;
import com.ziyao.ideal.uua.domain.dto.UserRoleDTO;
import com.ziyao.ideal.uua.domain.entity.UserRole;
import com.ziyao.ideal.uua.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhangziyao
 */
@RestController
@RequestMapping("/usercenter/user-role")
public class UserRoleController extends BaseController<UserRoleService, UserRole> {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/save")
    public void save(@RequestBody UserRoleDTO entityDTO) {
        super.iService.save(entityDTO.of());
    }

    @PostMapping("/saveOrUpdate")
    public void saveOrUpdate(@RequestBody UserRoleDTO entityDTO) {
        super.iService.saveOrUpdate(entityDTO.of());
    }

    @PostMapping("/updateById")
    public void updateById(@RequestBody UserRoleDTO entityDTO) {
        if (ObjectUtils.isEmpty(entityDTO.getId())) {
            throw Exceptions.createIllegalArgumentException(null);
        }
        super.iService.updateById(entityDTO.of());
    }

    /**
     * 默认一次插入500条
     */
    @PostMapping("/saveBatch")
    public void saveBatch(@RequestBody List<UserRoleDTO> entityDTOList) {
        super.iService.saveBatch(entityDTOList.stream().map(UserRoleDTO::of).collect(Collectors.toList()), 500);
    }

    /**
     * 条件分页查询
     *
     * @param pageParams 分页参数
     * @return 返回分页查询信息
     */
    @PostMapping("/page/get")
    public Page<UserRole> getPage(@RequestBody PageParams<UserRoleDTO> pageParams) {
        Page<UserRole> page = Pages.initPage(pageParams, UserRole.class);
        return userRoleService.page(page, pageParams.getParams());
    }
}
