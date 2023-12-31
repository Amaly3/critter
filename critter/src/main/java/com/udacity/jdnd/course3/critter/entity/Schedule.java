package com.udacity.jdnd.course3.critter.entity;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employeeIds;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pet> petIds;
    private LocalDate date;
    @NotNull
 //   @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass=EmployeeSkill.class)
    private Set<EmployeeSkill> activities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Employee> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Employee> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public List<Pet> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Pet> petIds) {
        this.petIds = petIds;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }
}
