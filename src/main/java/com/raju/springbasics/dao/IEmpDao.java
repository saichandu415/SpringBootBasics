package com.raju.springbasics.dao;

import com.raju.springbasics.model.Employee;

import java.util.List;

public interface IEmpDao {
    boolean createEmployee(Employee employee);

    List<Employee> getEmployeeList();

    boolean deleteEmployee(String id);
}
