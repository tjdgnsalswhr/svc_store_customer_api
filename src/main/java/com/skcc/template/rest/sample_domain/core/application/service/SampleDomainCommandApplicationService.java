package com.skcc.template.rest.sample_domain.core.application.service;

import java.util.Optional;

import com.skcc.template.rest.sample_domain.core.application.object.command.SampleDomainCommandApiRequestDTO;
import com.skcc.template.rest.sample_domain.core.domain.entity.SampleDomainAggregate;
import com.skcc.template.rest.sample_domain.core.port_infra.external_system.IExternalSampleSystem;
import com.skcc.template.rest.sample_domain.core.port_infra.persistent.ISampleDomainCommmandRepository;
import com.skcc.template.rest.sample_domain.infrastructure.external_system.ExternalSampleSystem_ATYPE;
import com.skcc.template.rest.sample_domain.infrastructure.external_system.ExternalSampleSystem_BTYPE;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SampleDomainCommandApplicationService implements ISampleDomainCommandApplicationService {

    private final ISampleDomainCommmandRepository sampleDomainCommmandRepository;
    private final ModelMapper modelMapper;
    
    @Override
    public void insertUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - insertUserStory [{}]", sampleDomainCommandApiRequestDTO);

        Optional<SampleDomainAggregate> queriedSampleDomainAggregate =  sampleDomainCommmandRepository.findById(sampleDomainCommandApiRequestDTO.getId());
        queriedSampleDomainAggregate.ifPresent( c -> {throw new IllegalArgumentException("이미 존재하는 객체 입니다.");} );

        SampleDomainAggregate sampleDomainAggregate = modelMapper.map(sampleDomainCommandApiRequestDTO, SampleDomainAggregate.class);
        sampleDomainCommmandRepository.save( sampleDomainAggregate );
    };

    @Transactional
    @Override
    public void updateUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - updateUserStory [{}]", sampleDomainCommandApiRequestDTO);
 
        Optional<SampleDomainAggregate> queriedSampleDomainAggregate =  sampleDomainCommmandRepository.findById(sampleDomainCommandApiRequestDTO.getId());
        queriedSampleDomainAggregate.orElseThrow( () -> new IllegalArgumentException("존재하지 않는 객체 입니다.") );

        if(sampleDomainCommandApiRequestDTO.getSampleData1() != null) queriedSampleDomainAggregate.get().setSampleData1( sampleDomainCommandApiRequestDTO.getSampleData1() );
        if(sampleDomainCommandApiRequestDTO.getSampleData2() != null) queriedSampleDomainAggregate.get().setSampleData2( sampleDomainCommandApiRequestDTO.getSampleData2() );
    };

    @Override
    public void updateOrInsertUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - updateOrInsertUserStory [{}]", sampleDomainCommandApiRequestDTO);

        SampleDomainAggregate sampleDomainAggregate = modelMapper.map(sampleDomainCommandApiRequestDTO, SampleDomainAggregate.class);

        sampleDomainCommmandRepository.save(sampleDomainAggregate);
    };


    @Override
    public void deleteUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - deleteUserStory [{}]", sampleDomainCommandApiRequestDTO);

        SampleDomainAggregate sampleDomainAggregate = modelMapper.map(sampleDomainCommandApiRequestDTO, SampleDomainAggregate.class);

        sampleDomainCommmandRepository.delete(sampleDomainAggregate);
    };

    @Override
    public ResponseEntity<String> doInterfaceExternalSystem(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO) {
        log.debug("[Service] SampleDomainApplicationService Called - doInterfaceExternalSystem [{}]", sampleDomainCommandApiRequestDTO);

        IExternalSampleSystem externalSampleSystem;
        
        if ("A".equals(sampleDomainCommandApiRequestDTO.getExternalSystemType())){
            externalSampleSystem = new ExternalSampleSystem_ATYPE();
        } else {
            externalSampleSystem = new ExternalSampleSystem_BTYPE();
        }

        //do Some Logic with External System
        return externalSampleSystem.doSomeExternalLogic( sampleDomainCommandApiRequestDTO );
    }
}
