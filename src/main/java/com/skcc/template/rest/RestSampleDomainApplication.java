package com.skcc.template.rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RestSampleDomainApplication {

	private static final String PROPERTIES =
									"spring.config.location="
									+ "classpath:/config/application/";
		
	public static void main(String[] args) {
		new SpringApplicationBuilder(RestSampleDomainApplication.class)
            .properties(PROPERTIES)
            .run(args);
	}

}
