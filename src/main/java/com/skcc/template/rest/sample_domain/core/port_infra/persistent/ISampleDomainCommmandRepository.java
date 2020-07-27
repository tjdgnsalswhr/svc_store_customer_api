package com.skcc.template.rest.sample_domain.core.port_infra.persistent;

import com.skcc.template.rest.sample_domain.core.domain.entity.SampleDomainAggregate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISampleDomainCommmandRepository extends JpaRepository<SampleDomainAggregate, String> {
}