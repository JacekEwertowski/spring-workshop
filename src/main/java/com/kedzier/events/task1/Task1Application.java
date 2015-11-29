package com.kedzier.events.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task1Application implements CommandLineRunner {

    @Autowired
    private DataSynchronizer synchronizer;

    public static void main(String[] args) {
        SpringApplication.run(Task1Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        synchronizer.synchronizeData();
    }

}
