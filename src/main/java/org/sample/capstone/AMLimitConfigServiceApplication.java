package org.sample.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class AMLimitConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AMLimitConfigServiceApplication.class, args);
	}
}
