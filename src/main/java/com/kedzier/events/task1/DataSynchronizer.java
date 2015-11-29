package com.kedzier.events.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kedzierm
 */
@Component
public class DataSynchronizer {

    private static final Logger LOG = LoggerFactory.getLogger(DataSynchronizer.class);

    @Autowired
    private DataSynchronizationNotifier notifier;

    @Autowired
    private DataSynchronizedWatcher watcher;

    public void synchronizeData() {

        LOG.debug("> Synchronizing data...");
        heavyAction();
        LOG.debug("< Synchronized.");

        // when data are synchronized few another things must happen
        notifier.sendNotification();
        watcher.markDataSynchronized();


    }

    private void heavyAction() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            LOG.error("Thread interrupted", e);
        }
    }

}
