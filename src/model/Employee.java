package model;

import java.util.Objects;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Role role;
    private double salary;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(salary, employee.salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, role, salary);
    }

    public Employee(int id, String firstName, String lastName, Role role, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        setSalary(salary);
    }

    public Employee( String firstName, String lastName, Role role, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "model.Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <=0) {
            throw new RuntimeException("Salary must be positive");
        }
        this.salary = salary;
    }
}
