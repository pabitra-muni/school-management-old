package org.ahant.admission.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by ahant on 7/16/2016.
 */
@Configuration
@PropertySource("classpath:properties/application-admission.properties")
public class AdmissionConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurerAuth() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
