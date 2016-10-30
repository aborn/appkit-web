package org.popkit.appkit.demo.service;

import org.popkit.appkit.log.AppKitLog;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-10-30:09:07
 */
public class ExecuteTask extends Thread {

    private String name;

    public ExecuteTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Callable<ExecuteStatus> demoTask = new Callable<ExecuteStatus>() {
            @Override
            public ExecuteStatus call() throws Exception {
                long beginTime = System.currentTimeMillis();
                String threadName = Thread.currentThread().getName();
                try {
                    int num = new Random().nextInt(60) + 1;
                    AppKitLog.info(name + " sleep " + num + " second. begin!" + threadName);
                    Thread.sleep(1000 * num);
                    AppKitLog.info(name + " sleep " + num + " second. finished!" + threadName);
                } catch (Exception throwable) {
                    AppKitLog.info("exception:");
                }
                long timeCost = (System.currentTimeMillis() - beginTime) / (1000);
                return new ExecuteStatus(true, "** ([" + name + "] finished! " + threadName + ") " + timeCost + "s **");
            }
        };

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<ExecuteStatus> future = service.submit(demoTask);

        //new Thread(futureTask).run();
        //futureTask.run();

        String threadName = Thread.currentThread().getName();
        try {
            ExecuteStatus status = future.get(30, TimeUnit.SECONDS);
            if (status == null) {
                AppKitLog.info("pkgName=[" + name + "] fetch future timeout!" + threadName);
            } else {
                AppKitLog.info("pkgName=[" + name + "] fetch future finished!" + status.getInfo() + threadName);
            }
        } catch (InterruptedException e) {
            AppKitLog.info("pkgName=[" + name + "]fetch timeout InterruptedException!" + threadName);
        } catch (ExecutionException e) {
            AppKitLog.info("pkgName=[" + name + "]fetch timeout ExecutionException!" + threadName);
        } catch (TimeoutException e) {
            future.cancel(true);
            AppKitLog.info("pkgName=[" + name + "]fetch timeout TimeoutException!" + threadName);
        } finally {

        }
    }
}
