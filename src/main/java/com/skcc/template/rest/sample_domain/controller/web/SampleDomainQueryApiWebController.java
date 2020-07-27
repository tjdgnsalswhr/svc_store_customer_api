package com.skcc.template.rest.sample_domain.controller.web;

import com.skcc.template.rest.sample_domain.core.application.object.query.SampleDomainQueryRequestDTO;
import com.skcc.template.rest.sample_domain.core.application.service.ISampleDomainQueryApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/rest/sample")
public class SampleDomainQueryApiWebController {

    @Autowired
    ISampleDomainQueryApplicationService sampleDomainQueryApplicationService;

    @GetMapping("/and")
    public ResponseEntity<Object> getAndSampleDomainAggregate( final SampleDomainQueryRequestDTO sampleDomainQueryRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - getSampleDomainAggregate");
        
        sampleDomainQueryApplicationService.queryAllAndUserStorySampleDomain(sampleDomainQueryRequestDTO);

        return new ResponseEntity<>( sampleDomainQueryApplicationService.queryAllAndUserStorySampleDomain(sampleDomainQueryRequestDTO)
                                    , HttpStatus.OK);
    }

    @GetMapping("/or")
    public ResponseEntity<Object> getOrSampleDomainAggregate( final SampleDomainQueryRequestDTO sampleDomainQueryRequestDTO ){
        log.debug("[Controller] SampleDomainWebController Called - getSampleDomainAggregate");
        
        return new ResponseEntity<>( sampleDomainQueryApplicationService.queryAllOrUserStorySampleDomain(sampleDomainQueryRequestDTO)
                                    , HttpStatus.OK);
    }

}