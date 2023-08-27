package com.udacity.jdnd.course3.critter.entity;

import com.udacity.jdnd.course3.critter.schedule.DAYS_OF_THE_WEEK;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Entity
public class Employee{

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ElementCollection(targetClass=DAYS_OF_THE_WEEK.class)
    private Set<DAYS_OF_THE_WEEK> daysAvailable;
    @ElementCollection(targetClass=EmployeeSkill.class)
    private Set<EmployeeSkill> skills;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "schedule_id")
    private Schedule scheduleID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DAYS_OF_THE_WEEK> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DAYS_OF_THE_WEEK> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Schedule getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(Schedule scheduleID) {
        this.scheduleID = scheduleID;
    }
}
