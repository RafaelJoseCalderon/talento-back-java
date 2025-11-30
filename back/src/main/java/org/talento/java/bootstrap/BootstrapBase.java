package org.talento.java.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public abstract class BootstrapBase implements InitializingBean {
    private final Logger log = LoggerFactory.getLogger(BootstrapBase.class);

    public abstract String entityMessage();
    public abstract void load();

    @Override
    public void afterPropertiesSet() {
        var message = this.entityMessage();

        log.info("#".repeat(100));
        log.info("# Loading {} ...{}#", message, " ".repeat(85 - message.length()));
        this.load();
        log.info("# Complete {} ...{}#", message, " ".repeat(84 - message.length()));
        log.info("#".repeat(100));
    }
}