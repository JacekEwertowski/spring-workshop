package com.kedzier.async.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class Task2Application implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Task2Application.class);

    @Autowired
    private Calculator distributionCalculator;

    public static void main(String[] args) {
        SpringApplication.run(Task2Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        Map<Integer, Integer> distributionMap = distributionCalculator.calculateRandomDistribution();
        LOG.info("Result [{}]", distributionMap);

    }

}
