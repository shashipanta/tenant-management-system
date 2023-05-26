package com.tms.tenantmanagementsystem.controller;

import com.tms.tenantmanagementsystem.dto.CustomMessage;
import com.tms.tenantmanagementsystem.dto.request.TenantRequest;
import com.tms.tenantmanagementsystem.dto.response.TenantResponse;
import com.tms.tenantmanagementsystem.service.TenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    // POST http://localhost:8888/api/tenants
    @PostMapping("/")
    public TenantResponse registerTenant(@RequestBody TenantRequest tenantRequest) {
        return tenantService.registerTenant(tenantRequest);
    }

    // GET http://localhost:8888/api/tenants
    @GetMapping("/")
    public List<TenantResponse> getAllRegisteredTenants() {
        return tenantService.getAllTenants();
    }

    // PUT http://localhost:8888/api/tenants/{id}
    @PutMapping("/{id}")
    public TenantResponse updateRegisteredTenant(
            @PathVariable("id") Long tenantId,
            @RequestBody TenantRequest tenantRequest
    ){

        return tenantService.updateTenant(tenantId, tenantRequest);
    }

    // GET http://localhost:8888/api/tenants/{id}
    @GetMapping("/{id}")
    public TenantResponse getRegisteredTenantById(@PathVariable("id") Long tenantId){
        return tenantService.getTenantById(tenantId);
    }

    // DELETE http://localhost:8888/api/tenants/{id}
    @DeleteMapping("/{id}")
    public CustomMessage deleteRegisteredTenant(@PathVariable("id") Long tenantId){
        return tenantService.deleteTenant(tenantId);
    }
}
