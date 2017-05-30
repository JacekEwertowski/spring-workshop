package com.kedzier.async.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

/**
 * @author kedzierm
 */
@Component
public class MyScheduledBean {

    private static final Logger LOG = LoggerFactory.getLogger(MyScheduledBean.class);

    @Autowired
    private HtmlReader htmlReader;

    @Autowired
    private TaskScheduler scheduler;

    private String last;

    void myMethod() {

        scheduler.schedule(() -> {
            try {
                String now = htmlReader.readHtml(new URL("http://onet.pl"));
                if (now.equals(last)) {
                    LOG.info("not changed");
                } else {
                    last = now;
                    LOG.info("changed");
                }
            } catch (IOException e) {
                LOG.error("error occurs", e);
            }
        }, new CronTrigger("0/5 * * * * ?"));
    }

}
