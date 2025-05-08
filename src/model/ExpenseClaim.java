package model;

import exceptions.InvalidDateException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class ExpenseClaim {

    private int id;
    private Employee employee;
    private BigDecimal amount;
    private boolean approved;
    private boolean paid;
    private LocalDate date;

    public ExpenseClaim(int id, Employee employee, BigDecimal amount, boolean approved, boolean paid, LocalDate date)
            throws InvalidDateException {
        if(date.isAfter(LocalDate.now())) {
            throw new InvalidDateException("Date cannot be in the future");
        }
        this.id = id;
        this.employee = employee;
        this.amount = amount;
        this.approved = approved;
        this.paid = paid;
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExpenseClaim{" +
                "id=" + id +
                ", employee=" + employee +
                ", amount=" + amount +
                ", approved=" + approved +
                ", paid=" + paid +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseClaim that = (ExpenseClaim) o;
        return id == that.id && approved == that.approved && paid == that.paid && Objects.equals(employee, that.employee) && Objects.equals(amount, that.amount) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, amount, approved, paid, date);
    }

    public int getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public boolean isApproved() {
        return approved;
    }

    public boolean isPaid() {
        return paid;
    }

    public LocalDate getDate() {
        return date;
    }
}
