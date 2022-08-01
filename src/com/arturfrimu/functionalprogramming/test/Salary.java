package com.arturfrimu.functionalprogramming.test;

import java.time.LocalDate;
import java.util.Objects;

public class Salary implements MoneyData {
    private int year;
    private int month;
    private int sum;

    public Salary(int year, int month, int sum) {
        this.year = year;
        this.month = month;
        this.sum = sum;
    }
    @Override
    public LocalDate getDate() {
        return LocalDate.of(this.year, this.month, 1);
    }

    @Override
    public String toString() {
        return "Salary{" +
                "year=" + year +
                ", month=" + month +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return year == salary.year && month == salary.month && sum == salary.sum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, sum);
    }
}
