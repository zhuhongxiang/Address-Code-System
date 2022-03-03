package com.address.system.core.dao;

import com.address.system.core.entity.address.AddressESEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
/*
address在elasticsearch中的dao
很多方法没用，疑似分词原因
 */
public interface AddressESRepository extends ElasticsearchRepository<AddressESEntity, String> {
}
