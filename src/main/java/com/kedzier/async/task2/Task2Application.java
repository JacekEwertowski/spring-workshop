package com.kedzier.async.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
public class Task2Application implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Task2Application.class);

    @Autowired
    private Calculator distributionCalculator;

    public static void main(String[] args) {
        SpringApplication.run(Task2Application.class, args);
    }

    @Bean
    @Qualifier("my")
    public Executor myExecutor() {
        ThreadPoolTaskExecutor myExecutor = new ThreadPoolTaskExecutor();
        myExecutor.setMaxPoolSize(10);
        myExecutor.setCorePoolSize(10);
        myExecutor.setThreadNamePrefix("MY_EXECUROR-thread-");
        return myExecutor;
    }

    @Override
    public void run(String... strings) throws Exception {

        Set<Future<Map<Integer, Integer>>> futuresSet = new HashSet<>();
        for (int i = 0; i< 100; i++) {
            futuresSet.add(distributionCalculator.calculateRandomDistribution());
        }

        Map<Integer,Integer> result = new HashMap<>();
        futuresSet.stream().forEach(future -> {
            try {
                harvestResult(future.get(), result);
            } catch (InterruptedException | ExecutionException e) {
                LOG.error("Error while processing", e);
            }
        });
        LOG.info("Result [{}]", result);

    }

    private void harvestResult(Map<Integer, Integer> partResult, Map<Integer, Integer> fullResult) {
        partResult.entrySet().stream().forEach(entry -> {
            Integer key = entry.getKey();
            Integer count = entry.getValue();
            if (fullResult.containsKey(key)) {
                fullResult.put(key, fullResult.get(key) + count);
            } else {
                fullResult.put(key, count);
            }
        });
    }

}
