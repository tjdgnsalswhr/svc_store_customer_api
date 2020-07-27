package com.skcc.template.rest.sample_domain.infrastructure.persistent;

import java.util.List;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.skcc.template.rest.sample_domain.core.application.object.query.SampleDomainQueryRequestDTO.SampleDomainKeyType;
import com.skcc.template.rest.sample_domain.core.domain.entity.QSampleDomainAggregate;
import com.skcc.template.rest.sample_domain.core.domain.entity.SampleDomainAggregate;
import com.skcc.template.rest.sample_domain.core.port_infra.persistent.ISampleDomainQueryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SampleDomainQueryDslRepository extends QuerydslRepositorySupport implements ISampleDomainQueryRepository {

    public SampleDomainQueryDslRepository() {
        super(SampleDomainAggregate.class);
    }

    @Override
    public Page<SampleDomainAggregate> searchAllAnd( final List<SampleDomainKeyType> searchKeys
                                                        , final List<String> searchvalues
                                                        , final Pageable pageable){

        log.debug("[Service] SampleDomainQueryDslRepository Called - searchAllAnd [{}][{}][{}]", searchKeys, searchvalues, pageable);

        final QSampleDomainAggregate sampleDomainAggregate = QSampleDomainAggregate.sampleDomainAggregate;
        final JPQLQuery<SampleDomainAggregate> query;

        query = from(sampleDomainAggregate);

        if (searchKeys != null && searchKeys.size() > 0){
            // where 조건 생성
            BooleanBuilder whereBuilder = new BooleanBuilder();

            for(int i=0; i<searchKeys.size(); i++){
                
                SampleDomainKeyType key = searchKeys.get(i);
                String value = searchvalues.get(i);

                switch (key) {
                    case id:{
                        whereBuilder.and(sampleDomainAggregate.id.eq(value));
                        break;
                    } case sampleData1:{
                        whereBuilder.and(sampleDomainAggregate.sampleData1.eq(value));
                        break;
                    } case sampleData2:{
                        whereBuilder.and(sampleDomainAggregate.sampleData2.eq(value));
                        break;
                    } default:{
                        throw new IllegalArgumentException();
                    }
                }
            }
            // where절 설정
            query.where(whereBuilder);
        }

        final List<SampleDomainAggregate> queryResults = getQuerydsl().applyPagination(pageable, query).fetch();
        return new PageImpl<>(queryResults, pageable, query.fetchCount());
    }

    @Override
    public Page<SampleDomainAggregate> searchAllOr( final List<SampleDomainKeyType> searchKeys
                                                    , final List<String> searchvalues
                                                    , final Pageable pageable){

        log.debug("[Service] SampleDomainQueryDslRepository Called - searchAllOr [{}][{}][{}]", searchKeys, searchvalues, pageable);
        final QSampleDomainAggregate sampleDomainAggregate = QSampleDomainAggregate.sampleDomainAggregate;
        final JPQLQuery<SampleDomainAggregate> query;

        query = from(sampleDomainAggregate);

        if (searchKeys != null && searchKeys.size() > 0){
            // where 조건 생성
            BooleanBuilder whereBuilder = new BooleanBuilder();

            for(int i=0; i<searchKeys.size(); i++){
                
                SampleDomainKeyType key = searchKeys.get(i);
                String value = searchvalues.get(i);

                switch (key) {
                    case id:{
                        whereBuilder.or(sampleDomainAggregate.id.eq(value));
                        break;
                    } case sampleData1:{
                        whereBuilder.or(sampleDomainAggregate.sampleData1.eq(value));
                        break;
                    } case sampleData2:{
                        whereBuilder.or(sampleDomainAggregate.sampleData2.eq(value));
                        break;
                    } default:{
                        throw new IllegalArgumentException();
                    }
                }
            }
            // where절 설정
            query.where(whereBuilder);
        }

        final List<SampleDomainAggregate> queryResults = getQuerydsl().applyPagination(pageable, query).fetch();
        return new PageImpl<>(queryResults, pageable, query.fetchCount());
    }
}