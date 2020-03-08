package com.simple.day06;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSimpleDateFormat {

    public static void main(String[] args) {
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> call=new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20200308",dtf);
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> futures =new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            futures.add(executorService.submit(call));
        }
        futures.forEach(System.out::println);

    }
}
