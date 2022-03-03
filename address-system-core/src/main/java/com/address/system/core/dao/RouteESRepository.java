package com.address.system.core.dao;

import com.address.system.core.entity.route.RouteESEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
/*
route在elasticsearch中的dao
 */
public interface RouteESRepository extends ElasticsearchRepository<RouteESEntity, String> {
}
