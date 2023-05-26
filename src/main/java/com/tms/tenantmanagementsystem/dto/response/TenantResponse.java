package com.tms.tenantmanagementsystem.dto.response;

import com.tms.tenantmanagementsystem.entity.Tenant;
import com.tms.tenantmanagementsystem.utils.DateTimeConverter;
import lombok.Data;

@Data
public class TenantResponse {

    private Long id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String joinedDateTime;

    public TenantResponse(Tenant tenant){
        this.id = tenant.getId();
        this.name = tenant.getName();
        this.address = tenant.getAddress();
        this.email = tenant.getEmail();
        this.phoneNumber = tenant.getPhoneNumber();
        this.joinedDateTime = DateTimeConverter.dateTimeToString(tenant.getJoinedAt());
    }
}
