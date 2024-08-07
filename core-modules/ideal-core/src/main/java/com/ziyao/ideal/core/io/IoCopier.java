package com.ziyao.ideal.core.io;

/**
 * @author ziyao zhang
 */
public abstract class IoCopier<S, T> {

    protected final int bufferSize;
    /**
     * 拷贝总数
     */
    protected final long count;

    /**
     * 进度条
     */
    protected StreamProgress progress;

    /**
     * 是否每次写出一个buffer内容就执行flush
     */
    protected boolean flushEveryBuffer;

    /**
     * 构造
     *
     * @param bufferSize 缓存大小，&lt; 0 表示默认{@link IOUtils#DEFAULT_BUFFER_SIZE}
     * @param count      拷贝总数，-1表示无限制
     * @param progress   进度条
     */
    public IoCopier(int bufferSize, long count, StreamProgress progress) {
        this.bufferSize = bufferSize > 0 ? bufferSize : IOUtils.DEFAULT_BUFFER_SIZE;
        this.count = count <= 0 ? Long.MAX_VALUE : count;
        this.progress = progress;
    }

    /**
     * 执行拷贝
     *
     * @param source 拷贝源，如InputStream、Reader等
     * @param target 拷贝目标，如OutputStream、Writer等
     * @return 拷贝的实际长度
     */
    public abstract long copy(S source, T target);

    /**
     * 缓存大小，取默认缓存和目标长度最小值
     *
     * @param count 目标长度
     * @return 缓存大小
     */
    protected int bufferSize(long count) {
        return (int) Math.min(this.bufferSize, count);
    }

    /**
     * 设置是否每次写出一个buffer内容就执行flush
     *
     * @param flushEveryBuffer 是否每次写出一个buffer内容就执行flush
     * @return this
     */
    public IoCopier<S, T> setFlushEveryBuffer(boolean flushEveryBuffer) {
        this.flushEveryBuffer = flushEveryBuffer;
        return this;
    }
}