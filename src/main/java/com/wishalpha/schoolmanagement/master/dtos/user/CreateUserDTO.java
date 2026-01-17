package com.wishalpha.schoolmanagement.master.dtos.user;

import com.wishalpha.schoolmanagement.common.utils.enums.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class CreateUserDTO {

    @Schema(example = "Priyanshu")
    @NotNull(message = "Name is required")
    private String name;

    @Schema(example = "admin@admin.com")
    @NotNull(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

    @Schema(example = "1234567890")
    @NotNull(message = "Contact No is required")
    private String contactNo;

    @Schema(example = "1234567890")
    private String altContactNo;

    @Schema(example = "2001-05-06")
    @NotNull(message = "DOB is required")
    @Past(message = "DOB must be a past date")
    private LocalDate dob;

    @Schema(example = "MALE")
    private Gender gender;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAltContactNo() {
        return altContactNo;
    }

    public void setAltContactNo(String altContactNo) {
        this.altContactNo = altContactNo;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
