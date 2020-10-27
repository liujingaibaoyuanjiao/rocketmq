package com.autobrain.utils;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static ThreadPoolExecutor getPool() {
        return new ThreadPoolExecutor(10, Integer.MAX_VALUE, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
    }

}
