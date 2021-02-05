xxl-job springboot 启动类

## 使用方法

1.添加如下依赖
```xml
    <dependency>
        <groupId>com.shareit</groupId>
        <artifactId>shareit-xxl-job-spring-boot-starter</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
```


2.配置如下配置
```properties
xxl.job.executor.log-path=log/jobhandler
xxl.job.executor.admin-addresses=http://demo/xxl-job-admin
xxl.job.executor.app-name=demo
```

3.服务端配置
xxljob服务端配置对应的执行器


## 停用自动配置

配置如下配置可停用功能
```properties
xxl.job.enable = false
```






