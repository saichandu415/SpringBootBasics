package com.raju.springbasics.service;

import com.raju.springbasics.dao.EmployeeDao;
import com.raju.springbasics.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> getEmployeeDetails(){
        final List<Employee> employeeList = employeeDao.getEmployeeList();
        return employeeList;
    }


    public boolean createEmployee(Employee employee){
        final boolean isAdded = employeeDao.createEmployee(employee);
        System.out.println("EmployeeService.createEmployee :: "+isAdded);

        return isAdded;
    }

    public boolean deleteEmployee(){
        final boolean isDeleted = employeeDao.deleteEmployee();
        return isDeleted;
    }

}
