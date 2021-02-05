package com.shareit.xxljob;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author huangcy_sh
 * @since 2021/2/4 20:37
 */
@EnableConfigurationProperties(XxlConfig.class)
@ConditionalOnClass(XxlJobSpringExecutor.class)
@ConditionalOnProperty(name = "xxl-job-enable", havingValue = "true", matchIfMissing = true)
public class XxlJobConfiguration {

    private static Logger log = LoggerFactory.getLogger(XxlJobConfiguration.class);

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor(XxlConfig properties) {
        log.info("xxljob config init start");
        log.info("xxljob.adminAddresses:{}", properties.getAdminAddresses());
        log.info("xxljob.appName:{}", properties.getAppName());
        log.info("xxljob.ip:{}", properties.getIp());
        log.info("xxljob.port:{}", properties.getPort());
        log.info("xxljob.accessToken:{}", properties.getAccessToken());
        log.info("xxljob.logPath:{}", properties.getLogPath());
        log.info("xxljob.logRetentionDays:{}", properties.getLogRetentionDays());
        propertiesCheck(properties);
        XxlJobSpringExecutor executor = new XxlJobSpringExecutor();
        executor.setAdminAddresses(properties.getAdminAddresses());
        executor.setAppName(properties.getAppName());
        executor.setIp(properties.getIp());
        executor.setPort(properties.getPort());
        executor.setAccessToken(properties.getAccessToken());
        executor.setLogPath(properties.getLogPath());
        executor.setLogRetentionDays(properties.getLogRetentionDays());
        return executor;
    }

    @Bean
    public JobAsyncHelper jobAsyncHelper() {
        return new JobAsyncHelper();
    }

    private void propertiesCheck(XxlConfig properties) {
        if (properties.getAdminAddresses() == null) {
            throw new RuntimeException("xxlJob缺少AdminAddresses");
        }
        if (properties.getAppName() == null) {
            throw new RuntimeException("xxlJob缺少appName");
        }
        if (properties.getLogPath() == null) {
            throw new RuntimeException("xxlJob缺少logPath");
        }
        if (properties.getPort() < 0) {
            throw new RuntimeException("xxlJob监听端口不能小于0");
        }
    }
}
