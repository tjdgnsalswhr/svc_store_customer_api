package com.skcc.template.rest.sample_domain.core.application.service;

import com.skcc.template.rest.sample_domain.core.application.object.command.SampleDomainCommandApiRequestDTO;

import org.springframework.http.ResponseEntity;

public interface ISampleDomainCommandApplicationService {
    
    public void insertUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO);

    public void updateOrInsertUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO);

    public void updateUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO);

    public void deleteUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO);

    public ResponseEntity<String> doInterfaceExternalSystem(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO);

}
