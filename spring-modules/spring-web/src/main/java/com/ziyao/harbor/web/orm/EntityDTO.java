package com.ziyao.harbor.web.orm;

import org.springframework.beans.BeanUtils;

/**
 * @author ziyao zhang
 */
public interface EntityDTO<T> {

    default Long getId() {
        return null;
    }

    /**
     * 获取实体属性
     */
    T getEntity();

    default T getInstance() {
        T entity = getEntity();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }
}
