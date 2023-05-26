package com.tms.tenantmanagementsystem.service;

import com.tms.tenantmanagementsystem.dto.CustomMessage;
import com.tms.tenantmanagementsystem.dto.request.TenantRequest;
import com.tms.tenantmanagementsystem.dto.response.TenantResponse;

import java.util.List;

public interface TenantService {

    TenantResponse registerTenant(TenantRequest tenantRequest);
    List<TenantResponse> getAllTenants();
    TenantResponse getTenantById(Long tenantId);
    TenantResponse updateTenant(Long tenantId, TenantRequest tenantRequest);
    CustomMessage deleteTenant(Long tenantId);
}
