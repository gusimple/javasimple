package com.simple.jdk8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @Auther gusim
 * @Date 2020/7/9
 */

public class TestTime {
    //获取当前时间
    @Test
    public void test1(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime of = LocalDateTime.of(2019, 2, 22, 2, 22, 22);
        System.out.println(of);
        //加
        LocalDateTime addYears = localDateTime.plusYears(1);
        //减
        LocalDateTime delYears = localDateTime.minusYears(2);
        int dayOfMonth = localDateTime.getDayOfMonth();
        System.out.println(dayOfMonth);

    }
    //instant
    //默认UTC时区时间
    @Test
    public void test2(){
        Instant now = Instant.now();
        System.out.println(now);
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }
    //计算两分时间间隔 Duration
    //计算日期 Period
    @Test
    public void test3() throws InterruptedException {
        Instant now = Instant.now();
        Thread.sleep(1000);
        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        System.out.println(between.toMillis());

        LocalDate of = LocalDate.of(2012, 2, 23);
        LocalDate now2 = LocalDate.now();
        Period between1 = Period.between(of, now2);
        System.out.println(between1.getYears());

    }
    @Test
    public void test4(){
        //时间校正器  TemporalAdjusters
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime1);
        System.out.println(localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));

    }
    //时间日期格式化
    @Test
    public void test5(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(dateTimeFormatter);
        System.out.println(format);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String format1 = localDateTime.format(dtf);
        System.out.println(format1);
    }
}
