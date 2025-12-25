package com.wishalpha.schoolmanagement.employee.entity;

import com.wishalpha.schoolmanagement.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "employee")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees", schema = "Employee")
public class EmployeeEntity extends BaseEntity {
    @NotNull(message = "Name is required")
    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "code", length = 200, unique = true)
    private String code;

    @NotNull(message = "Employee identifier is not generated, System Fault")
    @Column(name = "employee_identifier",unique = true, nullable = false)
    private String employeeIdentifier;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @Email(message = "Invalid email")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name="contact",length = 20, nullable = false)
    private String contact;

    @Column(name="alt_contact",length = 20)
    private String altContact;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name="joining_date")
    private LocalDate joiningDate;

    @Column(name = "specialization")
    private String specialization;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getEmployeeIdentifier() {
        return employeeIdentifier;
    }

    public void setEmployeeIdentifier(String employeeIdentifier) {
        this.employeeIdentifier = employeeIdentifier;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAltContact() {
        return altContact;
    }

    public void setAltContact(String altContact) {
        this.altContact = altContact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


}
