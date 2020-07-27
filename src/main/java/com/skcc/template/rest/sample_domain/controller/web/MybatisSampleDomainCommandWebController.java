package com.skcc.template.rest.sample_domain.controller.web;

import com.skcc.template.rest.sample_domain.core.application.object.command.SampleDomainCommandApiRequestDTO;
import com.skcc.template.rest.sample_domain.core.application.service.IMybatisSampleDomainCommandApplicationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/rest/sample/mybatis")
public class MybatisSampleDomainCommandWebController {
    @Autowired
    IMybatisSampleDomainCommandApplicationService iMybatisSampleDomainCommandApplicationService;

    @PostMapping
    public ResponseEntity<Object> postSampleDomainAggregate(@RequestBody @Valid SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO ){
        log.debug("[Controller] MybatisSampleDomainCommandWebController Called - postSampleDomainAggregate");
        iMybatisSampleDomainCommandApplicationService.insertUserStory(sampleDomainCommandApiRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> putSampleDomainAggregate( @RequestBody @Valid final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO ){
        log.debug("[Controller] MybatisSampleDomainCommandWebController Called - putSampleDomainAggregate");
        iMybatisSampleDomainCommandApplicationService.updateOrInsertUserStory(sampleDomainCommandApiRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping
    public ResponseEntity<Object> patchSampleDomainAggregate(@RequestBody @Valid final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO ){
        log.debug("[Controller] MybatisSampleDomainCommandWebController Called - patchSampleDomainAggregate");
        iMybatisSampleDomainCommandApplicationService.updateUserStory(sampleDomainCommandApiRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteSampleDomainAggregate(String id){
        log.debug("[Controller] SampleDomainWebController Called - deleteSampleDomainAggregate");
        iMybatisSampleDomainCommandApplicationService.deleteUserStory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
