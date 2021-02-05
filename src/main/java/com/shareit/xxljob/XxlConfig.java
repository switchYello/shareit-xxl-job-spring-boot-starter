package com.shareit.xxljob;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author huangcy_sh
 * @since 2021/2/4 20:33
 */
@ConfigurationProperties(prefix = "xxl.job.executor")
public class XxlConfig {

    //服务端地址
    private String adminAddresses;

    //这是执行器名
    private String appName;

    //本地ip，不写自动推测
    private String ip;

    //本地地址，不写自动查找可用的
    private int port = 0;

    //token
    private String accessToken;

    //日志地址
    private String logPath;

    //日志存储天数
    private int logRetentionDays = 7;

    public String getAdminAddresses() {
        return adminAddresses;
    }

    public void setAdminAddresses(String adminAddresses) {
        this.adminAddresses = adminAddresses;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public int getLogRetentionDays() {
        return logRetentionDays;
    }

    public void setLogRetentionDays(int logRetentionDays) {
        this.logRetentionDays = logRetentionDays;
    }
}
