package com.wishalpha.schoolmanagement.master.utils.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.wishalpha.schoolmanagement.common.responseHandler.ResponseHandler;

public enum ApplicationStatusEnum {
    ACTIVE("active"),
    INACTIVE("inactive"),
    BLOCKED("blocked"),
    MAINTENANCE("maintenance"),
    DRAFT("draft");

    private final String applicationStatus;

    ApplicationStatusEnum(String applicationStatus){
        this.applicationStatus = applicationStatus;
    }

    @JsonValue
    public String getApplicationStatus(){
        return applicationStatus;
    }

    public static ApplicationStatusEnum fromValue(String value){
        for(ApplicationStatusEnum status: values()){
            String currentStatus = status.getApplicationStatus();
            if(currentStatus.equals(value)){
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value for application status type Enum: "+ value);
    }
}
