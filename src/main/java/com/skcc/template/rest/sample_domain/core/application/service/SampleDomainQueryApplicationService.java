package com.skcc.template.rest.sample_domain.core.application.service;

import com.skcc.template.rest.sample_domain.core.application.object.query.SampleDomainQueryRequestDTO;
import com.skcc.template.rest.sample_domain.core.domain.entity.SampleDomainAggregate;
import com.skcc.template.rest.sample_domain.core.port_infra.persistent.ISampleDomainQueryRepository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SampleDomainQueryApplicationService implements ISampleDomainQueryApplicationService {

    private final ISampleDomainQueryRepository sampleDomainQueryRepository;
    
    @Override
    public Page<SampleDomainAggregate> queryAllAndUserStorySampleDomain(final SampleDomainQueryRequestDTO sampleDomainQueryRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - queryAllAndUserStorySampleDomain [{}]", sampleDomainQueryRequestDTO);

        return sampleDomainQueryRepository.searchAllAnd( sampleDomainQueryRequestDTO.getSearchKeys()
                                                        , sampleDomainQueryRequestDTO.getSearchvalues()
                                                        , sampleDomainQueryRequestDTO.of() );
    }

    @Override
    public Page<SampleDomainAggregate> queryAllOrUserStorySampleDomain(SampleDomainQueryRequestDTO sampleDomainQueryRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - queryAllOrUserStorySampleDomain [{}]", sampleDomainQueryRequestDTO);

        return sampleDomainQueryRepository.searchAllOr( sampleDomainQueryRequestDTO.getSearchKeys()
                                                        , sampleDomainQueryRequestDTO.getSearchvalues()
                                                        , sampleDomainQueryRequestDTO.of() );
    }
}
