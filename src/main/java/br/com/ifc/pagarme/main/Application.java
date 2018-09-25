package br.com.ifc.pagarme.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication(scanBasePackages= {"br.com.ifc.pagarme.config", "br.com.ifc.pagarme.controller", "br.com.ifc.pagarme.filter"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
