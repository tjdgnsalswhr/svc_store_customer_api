package com.skcc.template.rest.sample_domain.core.port_infra.persistent.mybatis;

import com.skcc.template.rest.sample_domain.core.application.object.command.SampleDomainResponseDTO;
import com.skcc.template.rest.sample_domain.core.domain.entity.SampleDomainAggregate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMybatisSampleDomainMapper {
    List<SampleDomainAggregate> findAll();
    SampleDomainAggregate findById(String id);
    void save(SampleDomainAggregate sampleDomainAggregate);
    void update(SampleDomainAggregate sampleDomainAggregate);
    void delete(String id);
}
