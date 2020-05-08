package util;

import static util.Util.logger;

public abstract class Logger {
    private final org.slf4j.Logger log = logger(getClass());

    public void log(Object o) {
        log.info(o + "");
    }
}
