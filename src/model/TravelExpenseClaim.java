package model;

import exceptions.InvalidDateException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TravelExpenseClaim extends ExpenseClaim {
    private String modeOfTransport;
    private String destination;

    public TravelExpenseClaim(int id, Employee employee, BigDecimal amount, boolean approved, boolean paid,
                              LocalDate date, String modeOfTransport, String destination) throws InvalidDateException {
        super(id, employee, amount, approved, paid, date);
        this.modeOfTransport = modeOfTransport;
        this.destination = destination;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "TravelExpenseClaim{" +
                "modeOfTransport='" + modeOfTransport + '\'' +
                ", destination='" + destination + '\'' +
                "} " + super.toString();
    }
}
