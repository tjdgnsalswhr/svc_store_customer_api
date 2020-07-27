package com.skcc.template.rest.sample_domain.core.application.service;

import com.skcc.template.rest.sample_domain.core.application.object.command.SampleDomainCommandApiRequestDTO;

public interface IMybatisSampleDomainCommandApplicationService {
    public void insertUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO);

    public void updateOrInsertUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO);

    public void updateUserStory(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO);

    public void deleteUserStory(final String id);

}
