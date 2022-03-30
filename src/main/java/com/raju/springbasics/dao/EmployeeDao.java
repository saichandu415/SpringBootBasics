package com.raju.springbasics.dao;

import com.raju.springbasics.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeDao implements IEmpDao {

    List<Employee> employeeList = new ArrayList<>();

    {
        employeeList.add(new Employee(UUID.randomUUID().toString(), "Raju", 24, true));
        employeeList.add(new Employee(UUID.randomUUID().toString(), "Sai", 25, true));
        employeeList.add(new Employee(UUID.randomUUID().toString(), "John", 26, false));
        employeeList.add(new Employee(UUID.randomUUID().toString(), "Doe", 27, true));
        employeeList.add(new Employee(UUID.randomUUID().toString(), "Sarah", 28, true));
    }


    @Override
    public boolean createEmployee(Employee employee) {
        final boolean isAdded = employeeList.add(employee);
        System.out.println("EmployeeDao.createEmployee :: " + employeeList.size());
        System.out.println(employeeList);
        return isAdded;
    }

    @Override
    public List<Employee> getEmployeeList(boolean isActive) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if(employee.isActive() ==  isActive)
                result.add(employee);
        }
        return result;
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

    @Override
    public boolean updateStatus(String id, boolean status) {
        int index = -1;
        Employee foundEmp = null;
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getId().equals(id)) {
                foundEmp = employee;
                foundEmp.setActive(status);
                index = i;
                break;
            }
        }
        if(index != -1){
            employeeList.remove(index);
            employeeList.add(index, foundEmp);
            return true;
        }else
            return false;

    }

    @Override
    public boolean updateEmployee(Employee updatedEmp) {
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getId().equals(updatedEmp.getId())) {
                index = i;
                break;
            }
        }
        if(index != -1){
            employeeList.remove(index);
            employeeList.add(index, updatedEmp);
            return true;
        }else
            return false;
    }


}
