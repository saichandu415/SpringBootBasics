package com.raju.springbasics.dao;

import com.raju.springbasics.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao implements IEmpDao {

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public boolean createEmployee(Employee employee) {
        final boolean isAdded = employeeList.add(employee);
        System.out.println("EmployeeDao.createEmployee :: " + employeeList.size());
        System.out.println(employeeList);
        return isAdded;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public boolean deleteEmployee(String id) {
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index == -1)
            return false;
        else {
            employeeList.remove(index);
            return true;
        }
    }


}
