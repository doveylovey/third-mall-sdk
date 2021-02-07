package com.sdk.common.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间工具类
 *
 * @author Administrator
 */
public class DatetimeUtils {
    private DatetimeUtils() {
        throw new AssertionError("No com.sdk.common.util.DatetimeUtils instances for you!");
    }

    public static String PATTERN_ALL_SPLIT = "yyyy-MM-dd HH:mm:ss";
    public static String PATTERN_ALL = "yyyyMMddHHmmss";
    public static String PATTERN_DATE_SPLIT = "yyyy-MM-dd";
    public static String PATTERN_DATE = "yyyyMMdd";
    public static String PATTERN_TIME_SPLIT = "HH:mm:ss";

    /**
     * 将指定日期时间格式化成 yyyy-MM-dd HH:mm:ss 形式
     *
     * @return
     */
    public static String getFormatDateTime(LocalDateTime localDateTime, String pattern) {
        /*String date = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = localDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String datetime1 = date + time;*/
        String datetime = localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        return datetime;
    }

    /**
     * 将指定日期时间转化成 LocalDateTime 对象
     *
     * @return
     */
    public static LocalDateTime str2DateTime(String string, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(string, formatter);
    }

    /**
     * 获取指定日期时间的秒值：10 位
     *
     * @param localDateTime
     * @return
     */
    public static long getSeconds(LocalDateTime localDateTime) {
        ZoneOffset zoneOffset = ZoneOffset.of("+8");
        long seconds = localDateTime.toEpochSecond(zoneOffset);
        return seconds;
    }

    /**
     * 获取指定日期时间的毫秒值：13 位
     *
     * @param localDateTime
     * @return
     */
    public static long getMilliSeconds(LocalDateTime localDateTime) {
        ZoneOffset zoneOffset = ZoneOffset.of("+8");
        Instant instant = localDateTime.toInstant(zoneOffset);
        long millisecond = instant.toEpochMilli();
        return millisecond;
    }
}
