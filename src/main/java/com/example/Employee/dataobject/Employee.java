package com.example.Employee.dataobject;

public class Employee {
    private String id;
    private String name;
    private String lastname;
    private String department;

    public Employee() {
        // Default constructor
    }

    public Employee(String id,String name,String lastname,String department){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.department = department;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }

    //Getter

    public Employee(Employee e) {
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastname;
    }

    public String getDepartment(){
        return this.department;
    }

    @Override
    public String toString() {
    return "Employee{" +
            "id='" + id + '\'' +
            ", firstName='" + name + '\'' +
            ", lastName='" + lastname + '\'' +
            ", department='" + department + '\'' +
            '}';
}

}
