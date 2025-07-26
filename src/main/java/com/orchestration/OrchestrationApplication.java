package com.orchestration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrchestrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestrationApplication.class, args);
		System.out.println("hi");
		System.out.println();
	}

	//Docker desktop
	//Docker-java for orchestration logic
	//PSQL for states and meta data
	//Kafka for sending data to elastic
	//Kibana for dashboards (debatable)
	//Portainer

	//Use AI for prediction load and analysing trends

}
