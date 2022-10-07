package com.employee.controller;


import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employee")
    private List<Employee> getAllEmployee() {
        LOGGER.info("Inside EmployeeController Class, Method : getAllEmployee");
        //When Arithmatic exception occur at line no 25 then Exception will log in Application.log file
        LOGGER.debug("Arithmatic Exception Occured");
//        System.out.println(10/0);
        return employeeService.getAllEmp();
    }

    @GetMapping("/employee/{empId}")
    private Employee getEmp(@PathVariable("empId") Long empId) {
        LOGGER.info("Inside EmployeeController Class, Method : getEmp by Id");
        return employeeService.getEmpById(empId);
    }

    @DeleteMapping("/employee/{empId}")
    private String deleteEmp(@PathVariable("empId") Long empId) {
        employeeService.delete(empId);
        LOGGER.info("Inside EmployeeController Class, Method : deleteEmp");
        return "Employee Deleted Successfully";
    }

    @PostMapping("/emp")
    private String addEmp(@RequestBody Employee employee) {
        employeeService.save(employee);
        LOGGER.info("Inside EmployeeController class, Method : addEmp");
        return "Employee Added Successfully";
    }

    @PutMapping("/updateEmployee")
    private String editEmp(@RequestBody Employee emp) {
        LOGGER.info("Inside EmployeeController Class, Method : editEmp");
        return employeeService.update(emp);
    }
}
