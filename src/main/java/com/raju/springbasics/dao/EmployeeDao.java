package com.raju.springbasics.dao;

import com.raju.springbasics.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    List<Employee> employeeList = new ArrayList<>();

    public boolean createEmployee(Employee employee){
        final boolean isAdded = employeeList.add(employee);
        System.out.println("EmployeeDao.createEmployee :: "+employeeList.size());
        System.out.println(employeeList);
        return isAdded;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public boolean deleteEmployee(){
       employeeList.remove(employeeList.size() - 1);
        return true;
    }


}
