package com.ziyao.harbor.usercenter.controllers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ziyao.harbor.usercenter.dto.MenuDTO;
import com.ziyao.harbor.usercenter.entity.Menu;
import com.ziyao.harbor.usercenter.service.MenuService;
import com.ziyao.harbor.web.base.BaseController;
import com.ziyao.harbor.web.base.PageParams;
import com.ziyao.harbor.web.base.Pages;
import com.ziyao.harbor.web.exception.Exceptions;
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
 * 菜单资源表 前端控制器
 * </p>
 *
 * @author zhangziyao
 */
@RestController
@RequestMapping("/usercenter/menu")
public class MenuController extends BaseController<MenuService, Menu> {

    @Autowired
    private MenuService menuService;

    @PostMapping("/save")
    public void save(@RequestBody MenuDTO entityDTO) {
        super.iService.save(entityDTO.getInstance());
    }

    @PostMapping("/saveOrUpdate")
    public void saveOrUpdate(@RequestBody MenuDTO entityDTO) {
        super.iService.saveOrUpdate(entityDTO.getInstance());
    }

    @PostMapping("/updateById")
    public void updateById(@RequestBody MenuDTO entityDTO) {
        if (ObjectUtils.isEmpty(entityDTO.getId())) {
            throw Exceptions.createIllegalArgumentException(null);
        }
        super.iService.updateById(entityDTO.getInstance());
    }

    /**
     * 默认一次插入500条
     */
    @PostMapping("/saveBatch")
    public void saveBatch(@RequestBody List<MenuDTO> entityDTOList) {
        super.iService.saveBatch(entityDTOList.stream().map(MenuDTO::getInstance).collect(Collectors.toList()), 500);
    }

    /**
     * 条件分页查询
     *
     * @param pageParams 分页参数
     * @return 返回分页查询信息
     */
    @PostMapping("/page/get")
    public Page<Menu> getPage(@RequestBody PageParams<MenuDTO> pageParams) {
        Page<Menu> page = Pages.initPage(pageParams, Menu.class);
        return menuService.page(page, pageParams.getParams());
    }
}
