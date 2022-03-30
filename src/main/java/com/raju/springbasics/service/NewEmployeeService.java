package com.raju.springbasics.service;

import com.raju.springbasics.dao.IEmpDao;
import com.raju.springbasics.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NewEmployeeService implements IEmpService {

    @Autowired
    IEmpDao employeeDao;

    @Override
    public List<Employee> getEmployeeDetails(boolean isActive){
        System.out.println("NewEmployeeService.getEmployeeDetails");
        final List<Employee> employeeList = employeeDao.getEmployeeList(isActive);
        return employeeList;
    }

    @Override
    public boolean createEmployee(Employee employee){
        employee.setId(UUID.randomUUID().toString());
        final boolean isAdded = employeeDao.createEmployee(employee);
        System.out.println("NewEmployeeService.createEmployee :: "+isAdded);
        return isAdded;
    }

    @Override
    public boolean deleteEmployee(String id){
        final boolean isDeleted = employeeDao.deleteEmployee(id);
        return isDeleted;
    }

    @Override
    public boolean updateStatus(String id, boolean status) {
        boolean isUpdated = employeeDao.updateStatus(id, status);
        return isUpdated;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        boolean isUpdated = employeeDao.updateEmployee(employee);
        return false;
    }
}
