package com.tms.tenantmanagementsystem.repo;

import com.tms.tenantmanagementsystem.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepo extends JpaRepository<Tenant, Long> {
}
