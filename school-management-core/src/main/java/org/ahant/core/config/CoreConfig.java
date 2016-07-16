package org.ahant.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by ahant on 3/19/2016.
 */
@Configuration
@PropertySource("classpath:properties/application-core.properties")
public class CoreConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurerCore() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
