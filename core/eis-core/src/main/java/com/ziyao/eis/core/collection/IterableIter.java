package com.ziyao.eis.core.collection;

import com.ziyao.eis.core.lang.NonNull;

import java.util.Iterator;

/**
 * 提供合成接口，共同提供{@link Iterable}和{@link Iterator}功能
 *
 * @param <T> 节点类型
 * @author ziyao zhang
 */
public interface IterableIter<T> extends Iterable<T>, Iterator<T> {

    @NonNull
    @Override
    default Iterator<T> iterator() {
        return this;
    }
}
