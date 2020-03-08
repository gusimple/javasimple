package com.simple.day06;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {
    private static final long serialVersionUID = 2293496430839980957L;

    private long start;
    private long end;
    private static final long THRESHOLD=10000;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long lengeth =end-start;
        if (lengeth<THRESHOLD){
            long sum=0;
            for (long i = start; i <=end ; i++) {
                sum+=i;
            }
            return sum;
        }else {
            long middle=(start+end)/2;
            ForkJoinCalculate left=new ForkJoinCalculate(start,middle);
            left.fork();//拆分任务
            ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
            right.fork();
            return left.join()+right.join();

        }
    }
}
