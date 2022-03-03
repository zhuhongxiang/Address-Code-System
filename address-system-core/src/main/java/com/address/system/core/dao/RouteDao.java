package com.address.system.core.dao;

import com.address.system.core.entity.route.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteDao extends JpaRepository<RouteEntity,String> {
    List<RouteEntity> findByPostmanId(String postmanId);

    List<RouteEntity> findByPostmanIdOrderByOrderId(String postmanId);
}
