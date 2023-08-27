package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.user.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    @Query("SELECT e FROM Employee e join e.skills es  " +
//            "WHERE es = :employeeDTO.skills and e.scheduleID.date=:employeeDTO.date")
//    List<Employee> findEmployeesForService(EmployeeRequestDTO employeeDTO);


        @Query("SELECT e FROM Employee e join e.skills es" +
                " WHERE e.scheduleID.date=:date and es =:employeeSkill")
        List<Employee> findEmployeesForService(Set<EmployeeSkill> employeeSkill, LocalDate date);

//    @Query("SELECT e FROM Employee e " +
//            "WHERE e.skills in (:employeeSkill) and e.scheduleID.date=:date")
//    List<Employee> findEmployeesForService(Set<EmployeeSkill> employeeSkill, LocalDate date);


}
