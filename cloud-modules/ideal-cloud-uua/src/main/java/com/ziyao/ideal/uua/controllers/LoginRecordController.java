package com.ziyao.ideal.uua.controllers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ziyao.ideal.web.base.BaseController;
import com.ziyao.ideal.web.base.PageParams;
import com.ziyao.ideal.web.base.Pages;
import com.ziyao.ideal.web.exception.Exceptions;
import com.ziyao.ideal.uua.domain.dto.LoginRecordDTO;
import com.ziyao.ideal.uua.domain.entity.LoginRecord;
import com.ziyao.ideal.uua.service.LoginRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 登录记录表 前端控制器
 * </p>
 *
 * @author zhangziyao
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/usercenter/login-record")
public class LoginRecordController extends BaseController<LoginRecordService, LoginRecord> {

    private final LoginRecordService loginRecordService;

    @PostMapping("/save")
    public void save(@RequestBody LoginRecordDTO entityDTO) {
        super.iService.save(entityDTO.getInstance());
    }

    @PostMapping("/saveOrUpdate")
    public void saveOrUpdate(@RequestBody LoginRecordDTO entityDTO) {
        super.iService.saveOrUpdate(entityDTO.getInstance());
    }

    @PostMapping("/updateById")
    public void updateById(@RequestBody LoginRecordDTO entityDTO) {
        if (ObjectUtils.isEmpty(entityDTO.getId())) {
            throw Exceptions.createIllegalArgumentException(null);
        }
        super.iService.updateById(entityDTO.getInstance());
    }

    /**
     * 默认一次插入500条
     */
    @PostMapping("/saveBatch")
    public void saveBatch(@RequestBody List
            <LoginRecordDTO> entityDTOList) {
        super.iService.saveBatch(entityDTOList.stream().map(LoginRecordDTO::getInstance).collect(Collectors.toList()), 500);
    }

    /**
     * 条件分页查询
     *
     * @param pageQuery 分页参数
     * @return 返回分页查询信息
     */
    @PostMapping("/page/get")
    public Page<LoginRecord> getPage(@RequestBody PageParams<LoginRecordDTO> pageQuery) {
        Page<LoginRecord> page = Pages.initPage(pageQuery, LoginRecord.class);
        return loginRecordService.page(page, pageQuery.getParams());
    }
}