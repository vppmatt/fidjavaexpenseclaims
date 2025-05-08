package utils;

import model.Employee;

import java.util.ArrayList;

public interface StorageFacility {

    void saveEmployee(Employee e);
    ArrayList<Employee> loadAllEmployees();

}
