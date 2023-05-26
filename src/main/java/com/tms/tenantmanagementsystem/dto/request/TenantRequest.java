package com.tms.tenantmanagementsystem.dto.request;

import com.tms.tenantmanagementsystem.entity.Tenant;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TenantRequest {

    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public TenantRequest(Tenant tenant){
        this.name = tenant.getName();
        this.address = tenant.getAddress();
        this.email = tenant.getEmail();
        this.phoneNumber = tenant.getPhoneNumber();
    }

    public static Tenant prepareToSave(TenantRequest tenantRequest){
        Tenant tenant = new Tenant();
        tenant.setName(tenantRequest.getName());
        tenant.setAddress(tenantRequest.getAddress());
        tenant.setEmail(tenantRequest.getEmail());
        tenant.setPhoneNumber(tenantRequest.getPhoneNumber());
        return tenant;
    }

    public static Tenant prepareToUpdate(TenantRequest tenantRequest, Tenant foundTenant){
        // based on the field provided update the found tenaant which gets saved
        if(tenantRequest.getName()!= null) foundTenant.setName(tenantRequest.getName());
        if(tenantRequest.getAddress() != null) foundTenant.setAddress(tenantRequest.getAddress());
        if(tenantRequest.getEmail() != null) foundTenant.setEmail(tenantRequest.getEmail());
        if(tenantRequest.getPhoneNumber() != null) foundTenant.setPhoneNumber(tenantRequest.getPhoneNumber());

        return foundTenant;
    }
}
