package com.hoy.user.logGenerator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class LogGeneratorService {

    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    public void stopScheduler(){
        threadPoolTaskScheduler.shutdown();
    }

    public void startScheduler(){
        threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.initialize();
        threadPoolTaskScheduler.schedule(getRunnerble(), getTrigger());

    }

    private Runnable getRunnerble() {
        return () -> {
            log.info("로그를 발생시켜 봅시다  {} ",new Random().nextDouble());
        };
    }

    private Trigger getTrigger() {

        return new PeriodicTrigger(1, TimeUnit.SECONDS);
    }

}
