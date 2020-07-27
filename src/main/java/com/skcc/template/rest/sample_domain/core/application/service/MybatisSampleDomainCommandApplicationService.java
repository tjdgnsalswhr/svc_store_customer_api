package com.skcc.template.rest.sample_domain.core.application.service;

import com.skcc.template.rest.sample_domain.core.application.object.command.SampleDomainCommandApiRequestDTO;
import com.skcc.template.rest.sample_domain.core.application.object.command.SampleDomainResponseDTO;
import com.skcc.template.rest.sample_domain.core.domain.entity.SampleDomainAggregate;
import com.skcc.template.rest.sample_domain.core.port_infra.persistent.mybatis.IMybatisSampleDomainMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MybatisSampleDomainCommandApplicationService implements IMybatisSampleDomainCommandApplicationService{
    private final IMybatisSampleDomainMapper iMybatisSampleDomainMapper;
    private final ModelMapper modelMapper;

    @Override
    public void insertUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO){

        log.debug("[Service] MybatisSampleDomainCommandApplicationService Called - insertUserStory [{}]", sampleDomainCommandApiRequestDTO);

        if(!(null ==iMybatisSampleDomainMapper.findById(sampleDomainCommandApiRequestDTO.getId()))){
            throw new IllegalArgumentException("이미 존재하는 객체 입니다.");
        }else{
            iMybatisSampleDomainMapper.save(modelMapper.map(sampleDomainCommandApiRequestDTO, SampleDomainAggregate.class));
        }
    }

    @Override
    public void updateUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO){
        log.debug("[Service] MybatisSampleDomainCommandApplicationService Called - updateUserStory [{}]", sampleDomainCommandApiRequestDTO);

        if(null==iMybatisSampleDomainMapper.findById(sampleDomainCommandApiRequestDTO.getId())){
            throw new IllegalArgumentException("존재하지 않는 객체 입니다.");
        }else{
            iMybatisSampleDomainMapper.update(modelMapper.map(sampleDomainCommandApiRequestDTO, SampleDomainAggregate.class));
        }
    }

    @Override
    public void deleteUserStory(String id) {
        log.debug("[Service] MybatisSampleDomainCommandApplicationService Called - deleteUserStory [{}]", id);

        if(null==iMybatisSampleDomainMapper.findById(id)){
            throw new IllegalArgumentException("존재하지 않는 객체 입니다.");
        }else{
            iMybatisSampleDomainMapper.delete(id);
        }
    }

    @Override
    public void updateOrInsertUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO){
        log.debug("[Service] MybatisSampleDomainCommandApplicationService Called - deleteUserStory [{}]", sampleDomainCommandApiRequestDTO);

        if(null==iMybatisSampleDomainMapper.findById(sampleDomainCommandApiRequestDTO.getId())){
            iMybatisSampleDomainMapper.save(modelMapper.map(sampleDomainCommandApiRequestDTO, SampleDomainAggregate.class));
        }else{
            iMybatisSampleDomainMapper.update(modelMapper.map(sampleDomainCommandApiRequestDTO, SampleDomainAggregate.class));
        }
    }

}
