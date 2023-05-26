package com.tms.tenantmanagementsystem.service.serviceImpl;

import com.tms.tenantmanagementsystem.dto.CustomMessage;
import com.tms.tenantmanagementsystem.dto.request.TenantRequest;
import com.tms.tenantmanagementsystem.dto.response.TenantResponse;
import com.tms.tenantmanagementsystem.entity.Tenant;
import com.tms.tenantmanagementsystem.repo.TenantRepo;
import com.tms.tenantmanagementsystem.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepo tenantRepo;

    @Override
    public TenantResponse registerTenant(TenantRequest tenantRequest) {

        Tenant tenant = TenantRequest.prepareToSave(tenantRequest);

        tenant = tenantRepo.save(tenant);

        return new TenantResponse(tenant);
    }

    @Override
    public List<TenantResponse> getAllTenants() {
        List<Tenant> tenantList = tenantRepo.findAll();

        List<TenantResponse> tenantResponseList = tenantList.stream()
                                                            .map(TenantResponse::new)
                                                            .collect(Collectors.toList());
        return tenantResponseList;
    }

    @Override
    public TenantResponse getTenantById(Long tenantId) {
        Tenant foundTenant = tenantRepo.findById(tenantId).orElseThrow();

        return new TenantResponse(foundTenant);
    }

    @Override
    public TenantResponse updateTenant(Long tenantId, TenantRequest tenantRequest) {
        Tenant foundTenant = tenantRepo.findById(tenantId).orElseThrow();
        // prepare to update
        foundTenant = TenantRequest.prepareToUpdate(tenantRequest, foundTenant);
        // update based on request
        foundTenant = tenantRepo.save(foundTenant);
        // return response
        return new TenantResponse(foundTenant);
    }

    @Override
    public CustomMessage deleteTenant(Long tenantId) {
        // try deleting tenant
        tenantRepo.deleteById(tenantId);

        Optional<Tenant> foundTenant = tenantRepo.findById(tenantId);
        if(foundTenant.isPresent()){
            return new CustomMessage("Could not delete tenant");
        }

        return new CustomMessage("Tenant deleted successfully");
    }
}
