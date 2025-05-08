import exceptions.InvalidDateException;
import model.Employee;
import model.ExpenseClaim;
import model.Role;
import model.TravelExpenseClaim;
import utils.DatabaseStorageFacility;
import utils.ECProcessor;
import utils.FileStorageFacility;
import utils.StorageFacility;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {



//        BigDecimal total = BigDecimal.ONE;
//        for (int i = 0; i < 10; i++) {
//            total = total.add(BigDecimal.valueOf(0.1));
//            System.out.println(total);
//        }
//        System.out.println(total);

        Employee matt = null;



        Employee e1 = new Employee();
        e1.setId(1);
        e1.setFirstName("Jim");
        e1.setLastName("Smith");
        e1.setSalary(123000);
        e1.setRole(Role.TEAM_LEAD);

        Employee e2 = new Employee(2, "Sally", "Jones",Role.SUPERVISOR,77500);

        System.out.println("model.Employee 1 has the id of " + e1.getId());
        System.out.println("model.Employee 1 is " + e1.getFirstName() + " " + e1.getLastName());
        System.out.println("model.Employee 1 is " + e1);
        System.out.println(e2);

        LocalDate today = LocalDate.now();

        ExpenseClaim ec1 = null;
        try {
            ec1 = new ExpenseClaim(1, e1, new BigDecimal(50), false, false, today);
        } catch (InvalidDateException e) {
            throw new RuntimeException(e);
        }

        System.out.println(ec1);

        ExpenseClaim ec2 = null;
        try {
            ec2 = new ExpenseClaim(1, e1, new BigDecimal(50), false, false, today);
        } catch (InvalidDateException e) {
            System.out.println("Date cannot be in the future - try again");
        } finally {
            System.out.println("This code will always run");
        }

        //expect: ec1 == ec2 : FALSE
        //expect ec1.equals(ec2): TRUE

        System.out.println("Does ec1.equal ec2? " + ec1.equals(ec2));


        TravelExpenseClaim tec = null;
        try {
            tec = new TravelExpenseClaim(2, e2, new BigDecimal("266.55"),
                    false, false, LocalDate.of(2026,5,6),
                    "Plane", "Dallas");
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());

        }

        System.out.println(tec);

        ECProcessor ecProcessor = new ECProcessor();
        ecProcessor.printTotalValueOfClaims();

        System.out.println(ecProcessor.getClass());

        ECProcessor.getVersionNumber();

        List<Employee> employees = new ArrayList<>();
        System.out.println(employees.size());
        employees.add(e1);
        employees.add(e2);
        System.out.println(employees.size());
        //employees.remove(e2);
        System.out.println(employees.get(1));
        System.out.println(employees);
        employees.add(e1);
        System.out.println("Employees size " + employees.size());

        HashSet<Employee> employeesSet = new HashSet<>();
        employeesSet.add(e1);
        employeesSet.add(e2);
        employeesSet.add(e1);
        System.out.println("EmployeesSet size " + employeesSet.size());

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getFirstName());
        }

        //foreach syntax
        for(Employee emp : employeesSet) {
            System.out.println("the current employee is " + emp);
        }

        StorageFacility sf = new FileStorageFacility("filename");
        sf.loadAllEmployees();
        sf.saveEmployee(e1);

        Map<Integer,Employee> employeesMap = new HashMap<>();
        employeesMap.put(e1.getId(), e1);
        employeesMap.put(2, e2);
        employeesMap.put(13, e1);
        employeesMap.put(2, null);
        System.out.println("Employees map" + employeesMap);


        Map<Employee, List<ExpenseClaim>> claims = new HashMap<>();
        claims.put(e1, new ArrayList<>());
        claims.get(e1).add(tec);
        claims.put(e2, new ArrayList<>());
        claims.get(e2).add(ec1);
        claims.get(e2).add(ec2);
        System.out.println("Employee 2 has " + claims.get(e2).size() + " claims");
        claims.put(e1, new ArrayList<>());

        List<Integer> ages = List.of(1,2,3,4,5);
        System.out.println(ages.getClass());

        Map<Integer, Integer> someValues = Map.of(1,7,2,9);



        System.out.println("=================");

        employees.add(new Employee(7, "Akanksha", "Raut", Role.MANAGER, 300000));
        employees.add(new Employee(8, "David", "Walsh", Role.TEAM_LEAD, 300000));
        employees.add(new Employee(9, "Teresa", "Rosemary", Role.TESTER, 300000));

        System.out.println(employees);

        System.out.println(employees.size());

        List<Employee> higherEarners = employees
                .stream()
                .filter( (emp) -> emp.getSalary() >= 300000)
                .toList();

        System.out.println("Higher earners " + higherEarners);

        //total salary bill
        Function<Employee, Double> extractSalary = emp -> emp.getSalary();

        System.out.println(employees.stream()
                .map(extractSalary)
                .toList());

        System.out.println(employees.stream()
                .map(emp -> emp.getSalary())
                .toList());

        Collections.sort(employees, (emp1, emp2) -> -emp1.getId().compareTo(emp2.getId()));

        System.out.println(employees);

        List<Employee> sortedEmployess = employees
                .stream()
                .sorted()
                .toList();
        System.out.println(sortedEmployess);

    }

}
