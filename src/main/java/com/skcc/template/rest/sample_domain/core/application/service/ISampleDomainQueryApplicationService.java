package com.skcc.template.rest.sample_domain.core.application.service;

import com.skcc.template.rest.sample_domain.core.application.object.query.SampleDomainQueryRequestDTO;
import com.skcc.template.rest.sample_domain.core.domain.entity.SampleDomainAggregate;

import org.springframework.data.domain.Page;

public interface ISampleDomainQueryApplicationService {
    
    public Page<SampleDomainAggregate> queryAllAndUserStorySampleDomain(final SampleDomainQueryRequestDTO sampleDomainQueryRequestDTO);

    public Page<SampleDomainAggregate> queryAllOrUserStorySampleDomain(final SampleDomainQueryRequestDTO sampleDomainQueryRequestDTO);

}
