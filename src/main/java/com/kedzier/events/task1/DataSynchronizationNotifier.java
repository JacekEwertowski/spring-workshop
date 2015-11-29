package com.kedzier.events.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author kedzierm
 */
@Component
public class DataSynchronizationNotifier {

    private static final Logger LOG = LoggerFactory.getLogger(DataSynchronizationNotifier.class);

    public void sendNotification() {
        String notificationContent = prepareContent();
        LOG.info("> Sending data synchronized notification: [{}]", notificationContent);

    }

    private String prepareContent() {
        return "Data synchronized on " + new Date();
    }

}
