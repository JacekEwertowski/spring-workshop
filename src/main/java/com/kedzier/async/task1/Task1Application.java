package com.kedzier.async.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task1Application implements CommandLineRunner {

    @Autowired
    private ImportantThingManager importantThingManager;

    public static void main(String[] args) {
        SpringApplication.run(Task1Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        for (int i = 0; i < 100 ; i++) {
            importantThingManager.doImportantThing();
        }

    }

}
