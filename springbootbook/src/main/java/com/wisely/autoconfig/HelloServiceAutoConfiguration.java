package com.wisely.autoconfig;

import com.wisely.config.HelloServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangqi on 16/7/4.
 */
@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)
public class HelloServiceAutoConfiguration {
}
