package com.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 2,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        threadPoolExecutor.submit(new MyRunable("p1"));
        threadPoolExecutor.execute(new MyRunable("p2"));

    }

    static class MyRunable implements Runnable {
        String name;

        MyRunable(String name) {
            this.name = name;
        }
        public void run() {
            System.out.println(name+"运行！");
        }
    }

}
