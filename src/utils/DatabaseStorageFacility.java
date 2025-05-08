package utils;

import model.Employee;

import java.util.ArrayList;

public class DatabaseStorageFacility implements StorageFacility {

    @Override
    public void saveEmployee(Employee e) {
        System.out.println("Saving employee " + e.getId());
    }

    @Override
    public ArrayList<Employee> loadAllEmployees() {
        return new ArrayList<>();
    }
}
