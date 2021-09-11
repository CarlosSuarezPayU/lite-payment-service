package com.senior.test.litepaymentservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Lite Payment Service that process payment and refunds request from the Startup.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@SpringBootApplication(scanBasePackages = {"com.senior.test.litepaymentservice"})
@EnableJpaRepositories("com.senior.test.litepaymentservice.usecase.share")
@EntityScan("com.senior.test.litepaymentservice.share.model.repository")
@EnableFeignClients(basePackages = {"com.senior.test.litepaymentservice.infrastructure.ports.out"})
public class LitePaymentServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(LitePaymentServiceApplication.class, args);
	}

}
