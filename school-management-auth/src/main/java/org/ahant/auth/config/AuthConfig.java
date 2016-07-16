package org.ahant.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by ahant on 3/20/2016.
 */
@Configuration
@PropertySource("classpath:properties/application-auth.properties")
public class AuthConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurerAuth() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
