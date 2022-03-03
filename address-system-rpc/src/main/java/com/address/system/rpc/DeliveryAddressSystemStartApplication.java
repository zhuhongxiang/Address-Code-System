package com.address.system.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.address.system")
@EnableElasticsearchRepositories("com.address.system")
@EnableJpaRepositories("com.address.system")
@EntityScan("com.address.system")
public class DeliveryAddressSystemStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DeliveryAddressSystemStartApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(DeliveryAddressSystemStartApplication.class, args);
    }
}
