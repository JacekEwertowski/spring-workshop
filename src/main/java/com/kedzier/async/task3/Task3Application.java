package com.kedzier.async.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

@SpringBootApplication
public class Task3Application implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Task3Application.class);

    @Autowired
    private HtmlReader htmlReader;

    public static void main(String[] args) {
        SpringApplication.run(Task3Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        LOG.info(htmlReader.readHtml(new URL("http://onet.pl")));
    }

}
