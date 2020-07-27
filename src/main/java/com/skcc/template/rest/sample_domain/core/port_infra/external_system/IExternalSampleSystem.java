package com.skcc.template.rest.sample_domain.core.port_infra.external_system;

import com.skcc.template.rest.sample_domain.core.application.object.command.SampleDomainCommandApiRequestDTO;

import org.springframework.http.ResponseEntity;

public interface IExternalSampleSystem {

    public ResponseEntity<String> doSomeExternalLogic(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO);

}