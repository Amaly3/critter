package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("select s from Schedule s join s.petIds sp where sp.id = :petId")
    List<Schedule> getScheduleForPet(Long petId);


    @Query("select s from Schedule s join s.employeeIds se where se.id = :employeeId")
    List<Schedule> getScheduleForEmployee(long employeeId);


    @Query("select s from Schedule s join s.petIds sp where sp.owner.id = :customerId")
    List<Schedule> getScheduleForCustomer(long customerId);
}
