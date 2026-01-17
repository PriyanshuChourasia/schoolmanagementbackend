package com.wishalpha.schoolmanagement.master.entities;

import com.wishalpha.schoolmanagement.common.entity.BaseEntity;
import com.wishalpha.schoolmanagement.common.utils.enums.Gender;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Tag(name = "User Schema")
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String code;

    @Column(unique = true, nullable = false)
    @Email(message = "Invalid email")
    private String email;


    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    @Column(name = "alt_contact_no")
    private String altContactNo;

    private LocalDate dob;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "user_type")
//    private UserTypeEnum userType;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "is_active")
    private boolean isActive = true;

    @Column(nullable = false)
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6,message = "Password length cannot be less than 6")
    private String password;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAltContactNo() {
        return altContactNo;
    }

    public void setAltContactNo(String altContactNo) {
        this.altContactNo = altContactNo;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
