package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.schedule.DAYS_OF_THE_WEEK;
import com.udacity.jdnd.course3.critter.user.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee CreateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id){
        Optional<Employee> optionalEmployee= employeeRepository.findById(id);

        if(optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }else{
                throw new EmployeeNotFoundException();
            }
    }

    public Employee setAvailability(Set<DAYS_OF_THE_WEEK> daysAvailable, Long employeeId){
        Optional<Employee> optionalEmployee= employeeRepository.findById(employeeId);
        if(optionalEmployee.isPresent()) {
            Employee employee= optionalEmployee.get();
            employee.setDaysAvailable(daysAvailable);

            return employeeRepository.save(employee);
        }else{
            throw new EmployeeNotFoundException();
        }
    }


    public List<Employee> findEmployeesForService(EmployeeRequestDTO employeeDTO){
        return employeeRepository.findEmployeesForService(employeeDTO.getSkills(), employeeDTO.getDate());
    }

}
