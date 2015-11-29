package com.kedzier.events.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author kedzierm
 */
@Component
public class DataSynchronizedWatcher {

    private static final Logger LOG = LoggerFactory.getLogger(DataSynchronizedWatcher.class);

    private boolean isDataSynchronized = false;
    private Date lastDataSynchronization = null;

    public void markDataSynchronized() {
        LOG.info("> Marking data as synchronized");
        isDataSynchronized = true;
        lastDataSynchronization = new Date();
    }

    public boolean isDataSynchronized() {
        return isDataSynchronized;
    }

    public Date getLastDataSynchronization() {
        return lastDataSynchronization;
    }
}
