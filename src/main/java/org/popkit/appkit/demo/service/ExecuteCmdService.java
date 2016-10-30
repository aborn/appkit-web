package org.popkit.appkit.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-10-30:09:00
 */
@Service
public class ExecuteCmdService {

    private final ExecutorService EXECUTOR_POOL = Executors.newFixedThreadPool(2);

    public void go() {
        new Thread(new Runnable() {
            public void run() {
                EXECUTOR_POOL.execute(new ExecuteTask("a"));
                EXECUTOR_POOL.execute(new ExecuteTask("b"));
                EXECUTOR_POOL.execute(new ExecuteTask("c"));
                EXECUTOR_POOL.execute(new ExecuteTask("d"));
                EXECUTOR_POOL.execute(new ExecuteTask("e"));
            }
        }).start();
    }
}
