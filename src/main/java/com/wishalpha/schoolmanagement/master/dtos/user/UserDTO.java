package com.wishalpha.schoolmanagement.master.dtos.user;

import com.wishalpha.schoolmanagement.common.utils.enums.Gender;

import java.time.LocalDate;

public class UserDTO {

    private String name;
    private String code;
    private String email;
    private boolean isActive;
    private String contactNo;
    private String altContactNo;
    private Gender gender;
    private LocalDate dob;

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAltContactNo() {
        return altContactNo;
    }

    public void setAltContactNo(String altContactNo) {
        this.altContactNo = altContactNo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDob(LocalDate dob){
        this.dob = dob;
    }

    public LocalDate getDob(){
        return this.dob;
    }

}
