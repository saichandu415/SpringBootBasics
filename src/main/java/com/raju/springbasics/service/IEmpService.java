package com.raju.springbasics.service;

import com.raju.springbasics.model.Employee;

import java.util.List;

public interface IEmpService {

    List<Employee> getEmployeeDetails(boolean isActive);

    boolean createEmployee(Employee employee);

    boolean deleteEmployee(String id);

    boolean updateStatus(String id, boolean status);

    boolean updateEmployee(Employee employee);
}
