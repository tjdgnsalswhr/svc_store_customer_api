package com.skcc.template.rest.sample_domain.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.internal.util.Assert;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@NoArgsConstructor
@Getter @Setter
@Builder
@Table(name = "SAMPLE_DOMAIN")
@Entity
public class SampleDomainAggregate {

    @Id
    private String id;
    @Column(nullable = true)
    private String sampleData1;
    @Column(nullable = true)
    private String sampleData2;
    
    public void doSomeAggregateBusinessLogic(){
        log.debug("[Aggregate Called][Logic] doSomeAggregateBusinessLogic[" + this.toString() + "]");
    }


    @Builder(builderClassName = "SampleDomainAggregateBuilder", builderMethodName = "of") // Key 기반 조회
    public SampleDomainAggregate(String id, String sampleData1, String sampleData2) {
        Assert.notNull(id, "ID must not be null");

        this.id = id;
        this.sampleData1 = sampleData1;
        this.sampleData2 = sampleData2;
    }

}