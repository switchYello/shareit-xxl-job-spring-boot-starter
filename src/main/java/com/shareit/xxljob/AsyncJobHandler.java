package com.shareit.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author huangcy_sh
 * @since 2021/02/04 20:40
 */
public abstract class AsyncJobHandler extends IJobHandler {

    private static Logger log = LoggerFactory.getLogger(AsyncJobHandler.class);

    @Resource
    private JobAsyncHelper jobAsyncHelper;

    @Override
    public void init() {
        MDC.put(Const.CTX_LOG_ID_MDC, UUID.randomUUID().toString().replace("-", ""));
    }

    @Override
    public ReturnT<String> execute(String param) {
        log("IJobHandler start");
        if (isAsync()) {
            jobAsyncHelper.execute(() -> run(param));
            return ReturnT.SUCCESS;
        }
        try {
            run(param);
            return ReturnT.SUCCESS;
        } catch (Exception e) {
            log.error("task throw exception", e);
            throw e;
        }
    }

    protected abstract void run(String s);

    protected boolean isAsync() {
        return false;
    }

    protected void log(String format, Object... data) {
        log.info(format, data);
        String mdc = MDC.get(Const.CTX_LOG_ID_MDC);
        Object[] objs = new Object[data.length + 1];
        objs[0] = mdc;
        System.arraycopy(data, 0, objs, 1, data.length);
        XxlJobLogger.log("[{}] " + format, objs);
    }
}