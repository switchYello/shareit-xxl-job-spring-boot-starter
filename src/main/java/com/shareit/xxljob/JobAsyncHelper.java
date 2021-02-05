package com.shareit.xxljob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

/**
 * @author huangcy_sh
 * @since 2021/2/4 20:47
 */
class JobAsyncHelper {

    private static Logger log = LoggerFactory.getLogger(JobAsyncHelper.class);

    @Async
    void execute(Runnable runnable) {
        log.info("run async");
        runnable.run();
    }

}
