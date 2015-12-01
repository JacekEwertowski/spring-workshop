package com.kedzier.async.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
public class Task3Application implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Task3Application.class);

    @Autowired
    private MyScheduledBean myScheduledBean;

    @Bean
    public TaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    public static void main(String[] args) {
        SpringApplication.run(Task3Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        myScheduledBean.myMethod();
    }

}
