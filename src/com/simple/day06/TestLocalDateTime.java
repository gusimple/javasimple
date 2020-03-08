package com.simple.day06;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestLocalDateTime {
    /**
     * 1 LocalDateTime
     * 2 Instant :时间戳 （以unix 元年：1970年1.1 00:00:00）
     * 3 Duration 计算两个时间之间的间隔
     * 4 Period 计算两个日期的的间距
     * 5 时间矫正器 TemporalAdjusters
     * 6 DateTimeFormatter:格式化时间 日期
     * 7 ZoneDate
     */
    @Test
    public void test7(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }
    @Test
    public void test6(){
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        String format = isoDateTime.format(now);
        System.out.println(format);
    }

    @Test
    public void test5(){
        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime with = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(with);
        ldt.with((l)->{
            LocalDateTime localDateTime=(LocalDateTime)l;
            DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.SATURDAY)){
                return localDateTime.plusDays(3);
            }
            return l;
        });

    }
    @Test
    public void test4(){
        LocalDate now = LocalDate.of(2011,11,22);

        LocalDate now1 = LocalDate.now();
        Period between = Period.between(now, now1);
        System.out.println(between);

    }
    @Test
    public void test3() throws InterruptedException {
        Instant now = Instant.now();
        Thread.sleep(1000);
        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        System.out.println(between.toMillis());
        System.out.println("----------------------------------");
        LocalTime localTime=LocalTime.now();
        Thread.sleep(1000);
        LocalTime localTime1=LocalTime.now();
        System.out.println(Duration.between(localTime, localTime1));

    }
    @Test
    public void test1(){
        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime of = LocalDateTime.of(2013, 12, 22, 22, 22);
        System.out.println(of);

        LocalDateTime localDateTime = ldt.plusYears(1);
        System.out.println(localDateTime);

    }
    @Test
    public void test2(){
        Instant now = Instant.now();//默认获取 UTC 时区
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(now);
    }

}
