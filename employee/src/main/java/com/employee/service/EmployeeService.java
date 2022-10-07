package com.employee.service;

import com.employee.controller.EmployeeController;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    public List<Employee> getAllEmp() {
        LOGGER.info("Inside EmployeeService Class, Method : getAllEmployee");
        return employeeRepository.findAll();
    }

    public Employee getEmpById(Long id) {
        LOGGER.info("Inside EmployeeService Class, Method : getEmployee by Id");
        return employeeRepository.findById(id).get();
    }

    public void save(Employee employee) {
        LOGGER.info("Inside EmployeeService Class, Method : addEmployee");
        employeeRepository.save(employee);
    }

    public void delete(Long id) {
        LOGGER.info("Inside EmployeeService Class, Method : deleteEmployee");
        employeeRepository.deleteById(id);
    }

    public String update(Employee emp) {
        Optional<Employee>update = employeeRepository.findById(emp.getEmpId());
        employeeRepository.save(emp);
        LOGGER.info("Inside EmployeeService Class, Method : updateEmployee");
        if(update != null){
            employeeRepository.save(emp);
            return "Updated Successfully";
        }
        else
            return "Not Updated";
    }
}
