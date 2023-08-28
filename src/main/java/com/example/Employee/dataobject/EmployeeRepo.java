package com.example.Employee.dataobject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepo {
    List<Employee> employeeList = new ArrayList<>();

    public EmployeeRepo(){
        employeeList.add( new Employee("EMP001", "Henry", "Walker", "Production"));
        employeeList.add( new Employee("EMP002", "Ohm", "Jirawut", "Logistics"));
        employeeList.add( new Employee("EMP003", "Pim", "Wasdasd", "Production"));
        employeeList.add( new Employee("EMP004", "DOg", "Wzxczxczc", "HRM"));
        employeeList.add( new Employee("EMP005", "Easdasd", "Wzxczxczc", "Marketing"));
    }

    public List<Employee> getAll(){
        return employeeList;
    }

    public int countEmployees(){
        return employeeList.size();
    }

    public Employee getEmployee(String id) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (id.equals(employee.getId())) {
                return employee; 
            }
        }
        return null;
    }

    public List<Employee> getEmployeesByDept(String dept){
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (dept.equals(employee.getDepartment())) {
               result.add(employee);
            }
        }
        return result;
    }

    public String postEmployee(Employee e){
        System.out.println(e);
        employeeList.add(new Employee(e));
        return "Sucess";
    }

    public String putEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (updatedEmployee.getId().equals(employee.getId())) {
                employeeList.set(i, updatedEmployee);
                return "เรียบร้อย";
            }
        }
        return "asdasdasd"; 
    }

    public String deleteEmployee(String id) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (id.equals(employee.getId())) {
                employeeList.remove(i);
                return "ลบพนักงานเรียบร้อยแล้ว";
            }
        }
        return "ไม่พบพนักงานที่ต้องการลบ";
    }
    
    
    
}
