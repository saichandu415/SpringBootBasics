package com.raju.springbasics.service;

import com.raju.springbasics.dao.IEmpDao;
import com.raju.springbasics.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    // IEmployeeService - EmployeeService
    // EmployeeService - EmployeeServiceImpl

    @Autowired
    IEmpDao employeeDao;

//    @Override
    public List<Employee> getEmployeeDetails(boolean isActive){
        final List<Employee> employeeList = employeeDao.getEmployeeList(isActive);
        return employeeList;
    }

//    @Override
    public boolean createEmployee(Employee employee){
        final boolean isAdded = employeeDao.createEmployee(employee);
        System.out.println("EmployeeService.createEmployee :: "+isAdded);
        return isAdded;
    }

//    @Override
    public boolean deleteEmployee(String id){
        final boolean isDeleted = employeeDao.deleteEmployee(id);
        return isDeleted;
    }

}
