package com.terafuze.gohomenotes.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 */
@Entity
@Table(name = "student_registration")
public class StudentRegistration implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    
    @ManyToOne
    private FamilyRegistration familyRegistration;
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    
    @ManyToOne
    private SchoolGrade schoolGrade;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    public FamilyRegistration getFamilyRegistration() {
        return this.familyRegistration;
    }

    public StudentRegistration familyRegistration(FamilyRegistration familyRegistration) {
        this.familyRegistration = familyRegistration;
        return this;
    }

    public void setFamilyRegistration(FamilyRegistration familyRegistration) {
        this.familyRegistration = familyRegistration;
    }


    
    public String getFirstName() {
        return this.firstName;
    }

    public StudentRegistration firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    public String getLastName() {
        return this.lastName;
    }

    public StudentRegistration lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    
    public SchoolGrade getSchoolGrade() {
        return this.schoolGrade;
    }

    public StudentRegistration schoolGrade(SchoolGrade schoolGrade) {
        this.schoolGrade = schoolGrade;
        return this;
    }

    public void setSchoolGrade(SchoolGrade schoolGrade) {
        this.schoolGrade = schoolGrade;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentRegistration studentRegistration = (StudentRegistration) o;
        if (studentRegistration.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), studentRegistration.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StudentRegistration{" +
            "id=" + getId() +
            ", familyRegistration='" + getFamilyRegistration() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", schoolGrade='" + getSchoolGrade() + "'" +
            "}";
    }
}