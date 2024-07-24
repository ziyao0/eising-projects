package com.ziyao.ideal.web.base;

import lombok.Data;

/**
 * @author ziyao zhang
 */
@Data
public class PageParams<T> {

    private T params;

    private PageI page = new PageI();


    @Data
    public static class PageI {

        /**
         * 当前页条数
         */
        private long size = 10;

        /**
         * 当前页
         */
        private long current = 1;

    }
}
