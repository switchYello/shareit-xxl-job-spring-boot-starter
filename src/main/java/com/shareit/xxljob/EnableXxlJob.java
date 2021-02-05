package com.shareit.xxljob;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author huangcy_sh
 * @since 2021/2/4 20:35
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(XxlJobConfiguration.class)
@Documented
public @interface EnableXxlJob {


}
