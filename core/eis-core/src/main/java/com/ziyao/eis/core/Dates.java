package com.ziyao.eis.core;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangziyao
 */
public abstract class Dates {


    private Dates() {
    }

    public static String formatOfDay() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Formatter.DAY.getPattern()));
    }

    public static String formatOfMonth() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Formatter.MONTH.getPattern()));
    }

    public static String formatOfYear() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Formatter.YEAR.getPattern()));
    }

    /**
     * 判断是是否过期 误差为1分钟 一分钟之内都算过期
     *
     * @param expiresAt 时间类型
     */
    public static boolean isExpired(Date expiresAt) {
        final Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, 2);
        Date date = instance.getTime();
        return expiresAt.compareTo(date) <= 0;
    }

    /**
     * 判断是是否过期 误差为1分钟 一分钟之内都算过期
     *
     * @param expiresAt 时间类型
     */
    public static boolean isExpired(Date expiresAt, int amount) {
        final Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, amount);
        Date date = instance.getTime();
        return expiresAt.compareTo(date) <= 0;
    }

    /**
     * 跳跃到指定的时间之后 （单位：分钟）
     *
     * @param minute 分钟数
     */
    public static Date skip(int minute) {
        final Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, minute);
        return instance.getTime();
    }

    public static Instant toInstant(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }

    public static LocalDateTime toLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
