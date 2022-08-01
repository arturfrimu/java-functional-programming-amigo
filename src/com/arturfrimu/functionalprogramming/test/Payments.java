package com.arturfrimu.functionalprogramming.test;

import java.time.LocalDate;
import java.util.Objects;

public class Payments implements MoneyData {
    private LocalDate date;
    private int sum;

    public Payments(LocalDate date, int sum) {
        this.date = date;
        this.sum = sum;
    }


    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "date=" + date +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payments payments = (Payments) o;
        return sum == payments.sum && Objects.equals(date, payments.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, sum);
    }
}
