package com.skcc.template.rest.sample_domain.infrastructure.external_system;

import java.time.Duration;

import com.skcc.template.rest.common.error.handler.RestTemplateErrorHandler;
import com.skcc.template.rest.common.intercept.RestTemplateClientHttpRequestInterceptor;
import com.skcc.template.rest.sample_domain.core.application.object.command.SampleDomainCommandApiRequestDTO;
import com.skcc.template.rest.sample_domain.core.port_infra.external_system.IExternalSampleSystem;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExternalSampleSystem_BTYPE implements IExternalSampleSystem {

    private RestTemplateBuilder restTemplateBuilder;
    private RestTemplate restTemplate;
    
    public ExternalSampleSystem_BTYPE(){
        
        restTemplateBuilder = new RestTemplateBuilder();

        restTemplate = restTemplateBuilder.rootUri("http://localhost:8080")
                                        .additionalInterceptors(new RestTemplateClientHttpRequestInterceptor())
                                        .errorHandler(new RestTemplateErrorHandler())
                                        .setConnectTimeout(Duration.ofMinutes(3))
                                        .build();
    }

    @Override
    public ResponseEntity<String> doSomeExternalLogic( final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO ) {
        log.debug("[ExternalSampleSystem_BTYPE Called] doSomeExternalLogic");

        ResponseEntity<String> result = restTemplate.getForEntity("/404", String.class);
        
        return result;
    }

}