package com.address.system.core.dao;

import com.address.system.core.entity.standardAddress.StandardAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardAddressDao extends JpaRepository<StandardAddressEntity, String> {
}
