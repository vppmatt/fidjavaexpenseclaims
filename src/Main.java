import exceptions.InvalidDateException;
import model.Employee;
import model.ExpenseClaim;
import model.Role;
import model.TravelExpenseClaim;
import utils.ECProcessor;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    }

}
