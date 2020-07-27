package com.skcc.template.rest.sample_domain.core.port_infra.persistent;

import java.util.List;

import com.skcc.template.rest.sample_domain.core.application.object.query.SampleDomainQueryRequestDTO.SampleDomainKeyType;
import com.skcc.template.rest.sample_domain.core.domain.entity.SampleDomainAggregate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISampleDomainQueryRepository {

    public Page<SampleDomainAggregate> searchAllAnd(final List<SampleDomainKeyType> searchKeys
                                                    , final List<String> searchvalues
                                                    , final Pageable pageable );

    public Page<SampleDomainAggregate> searchAllOr(final List<SampleDomainKeyType> searchKeys
                                                    , final List<String> searchvalues
                                                    , final Pageable pageable );
}