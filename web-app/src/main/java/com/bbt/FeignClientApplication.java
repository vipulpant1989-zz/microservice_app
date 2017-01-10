package com.bbt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignClientApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(FeignClientApplication.class).web(true)
				.run(args);
	}

}
