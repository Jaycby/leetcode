package com.Jaycby.Bag.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName pool
 * @Author cby
 * @Date 2023/1/13 9:59
 * @Version 1.0
 */
public class pool {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(() ->{
            System.out.println("1");
        });

        pool.execute(() -> {
            System.out.println("2");
        });

        pool.execute(() -> {
            System.out.println("3");
        });
    }
}
