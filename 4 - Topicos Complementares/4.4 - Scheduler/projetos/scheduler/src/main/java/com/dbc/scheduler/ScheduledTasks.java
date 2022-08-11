package com.dbc.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // executa conta o tempo à partir do íncio da execução do método
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws InterruptedException {
        log.info("The time is now {}", dateFormat.format(new Date()));
        Thread.sleep(1000);
    }

//    // executa conta o tempo à partir do fim da execução do método
//    @Scheduled(fixedDelay = 5000)
//    public void reportCurrentTimeDelay() throws InterruptedException {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//        Thread.sleep(1000);
//    }

//
//    // https://www.manpagez.com/man/5/crontab/
//    // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html

//    @Scheduled(cron = "*/10 * * * * *" )
//    public void reportCurrentTimeCron() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }
//
//    @Scheduled(cron = "*/10 * * * * *" )
//    public void reportCurrentTimeCron() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }

//    @Scheduled(cron = "0 49 9-19 * * *", zone = "GMT-3")
//    public void reportCurrentTimeCronDas15as19() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }


//    @Scheduled(cron = "0 43  9-19 * * *")
//    public void reportCurrentTimeCronDas15as19() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }
}