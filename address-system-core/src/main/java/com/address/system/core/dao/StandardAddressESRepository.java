package com.address.system.core.dao;

import com.address.system.core.entity.standardAddress.StandardAddressESEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardAddressESRepository extends ElasticsearchRepository<StandardAddressESEntity, String> {
}
