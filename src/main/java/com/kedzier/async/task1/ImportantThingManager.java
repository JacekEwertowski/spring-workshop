package com.kedzier.async.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author kedzierm
 */
@Component
public class ImportantThingManager {

    private static final Logger LOG = LoggerFactory.getLogger(ImportantThingManager.class);

    public void doImportantThing() {
        LOG.debug("> About to start important job...");
        heavyAction();
        LOG.debug("< Important job finished.");
    }

    private void heavyAction() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            LOG.error("Thread interrupted", e);
        }
    }

}
