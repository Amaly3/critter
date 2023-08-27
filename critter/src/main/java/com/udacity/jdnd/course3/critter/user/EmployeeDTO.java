package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.DAYS_OF_THE_WEEK;

import java.time.DayOfWeek;
import java.util.Set;

/**
 * Represents the form that employee request and response data takes. Does not map
 * to the database directly.
 */
public class EmployeeDTO {
    private long id;
    private String name;
    private Set<EmployeeSkill> skills;
    private Set<DAYS_OF_THE_WEEK> daysAvailable;
    private Schedule scheduleID;

    public Schedule getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(Schedule scheduleID) {
        this.scheduleID = scheduleID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<DAYS_OF_THE_WEEK> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DAYS_OF_THE_WEEK> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }
}

