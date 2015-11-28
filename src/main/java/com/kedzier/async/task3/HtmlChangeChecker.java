package com.kedzier.async.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

/**
 * @author kedzierm
 */
@Component
public class HtmlChangeChecker {

    private static final String URL_TO_CHECK = "http://onet.pl";

    private static final Logger LOG = LoggerFactory.getLogger(HtmlChangeChecker.class);

    @Autowired
    private HtmlReader htmlReader;

    private String lastSource = "";

    @Scheduled(cron = "0/30 * * * * ?")
    public void checkIfSourceHasChanged() throws IOException {

        String currentSource = htmlReader.readHtml(new URL(URL_TO_CHECK));


        if (lastSource.equals(currentSource)) {
            LOG.info("Source has not changed");
        } else {
            LOG.info("Source has changed");
            lastSource = currentSource;
        }

    }

}
