package com.skcc.template.rest.sample_domain.controller.web;

import javax.validation.Valid;

import com.skcc.template.rest.sample_domain.core.application.object.command.SampleDomainCommandApiRequestDTO;
import com.skcc.template.rest.sample_domain.core.application.service.ISampleDomainCommandApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/rest/sample")
public class SampleDomainCommandWebController {

    @Autowired
    ISampleDomainCommandApplicationService sampleDomainCommandApplicationService;

    @PostMapping
    public ResponseEntity<Object> postSampleDomainAggregate( @RequestBody @Valid SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - postSampleDomainAggregate");

        sampleDomainCommandApplicationService.insertUserStory(sampleDomainCommandApiRequestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> putSampleDomainAggregate( @RequestBody @Valid final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - putSampleDomainAggregate");

        sampleDomainCommandApplicationService.updateOrInsertUserStory(sampleDomainCommandApiRequestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Object> patchSampleDomainAggregate(@RequestBody @Valid final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - patchSampleDomainAggregate");

        sampleDomainCommandApplicationService.updateUserStory(sampleDomainCommandApiRequestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteSampleDomainAggregate(@RequestBody @Valid final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - deleteSampleDomainAggregate");

        sampleDomainCommandApplicationService.deleteUserStory(sampleDomainCommandApiRequestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/external")
    public ResponseEntity<String> doInterfaceExternalSystem( @RequestBody SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - doInterfaceExternalSystem");

        return sampleDomainCommandApplicationService.doInterfaceExternalSystem(sampleDomainCommandApiRequestDTO);
    }

}