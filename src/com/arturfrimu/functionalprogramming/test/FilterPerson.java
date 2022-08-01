package com.arturfrimu.functionalprogramming.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class FilterPerson {
    public static void main(String[] args) {
        List<MoneyData> payments = List.of(
                new Payments(LocalDate.of(2021, 12, 1), 1000),
                new Payments(LocalDate.of(2022, 1, 1), 1000),
                new Payments(LocalDate.of(2022, 2, 1), 1000),
                new Payments(LocalDate.of(2022, 3, 1), 1000),
                new Payments(LocalDate.of(2022, 4, 2), 1000),
                new Payments(LocalDate.of(2022, 4, 1), 1000),
                new Payments(LocalDate.of(2022, 5, 1), 1000),
                new Payments(LocalDate.of(2022, 6, 1), 1000),
                new Payments(LocalDate.of(2022, 7, 1), 1000),
                new Payments(LocalDate.of(2022, 8, 1), 1000),
                new Payments(LocalDate.of(2022, 9, 1), 1000),
                new Payments(LocalDate.of(2022, 10, 1), 1000),
                new Payments(LocalDate.of(2022, 11, 1), 1000),
                new Payments(LocalDate.of(2022, 12, 1), 1000)
        );

        List<MoneyData> salaries = List.of(
                new Salary(2021, 12, 1000),
                new Salary(2022, 1, 1000),
                new Salary(2022, 2, 1000),
                new Salary(2022, 3, 1000),
                new Salary(2022, 4, 1000),
                new Salary(2022, 4, 1000),
                new Salary(2022, 5, 1000),
                new Salary(2022, 6, 1000),
                new Salary(2022, 7, 1000),
                new Salary(2022, 8, 1000),
                new Salary(2022, 9, 1000),
                new Salary(2022, 10, 1000),
                new Salary(2022, 11, 1000),
                new Salary(2022, 12, 1000)
        );

        Scanner scanner = new Scanner(System.in);
        LocalDate to = LocalDate.now();
        LocalDate from = to.minusMonths(scanner.nextInt());

        Predicate<MoneyData> dataFilter = createDataFilter(from, to);

        List<MoneyData> filteredPayments = filter(payments, dataFilter);
        filteredPayments.stream().collect(groupingBy(data -> data.getDate().getYear(), groupingBy(data -> data.getDate().getMonth())))
                .forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("\n");
        List<MoneyData> filteredSalaries = filter(salaries, dataFilter);
    }

    private static Predicate<MoneyData> createDataFilter(LocalDate from, LocalDate to) {
        return data -> data.getDate().isAfter(from) && data.getDate().isBefore(to);
    }

    private static List<MoneyData> filter(List<MoneyData> people, Predicate<MoneyData> predicate) {
        return people.stream().filter(predicate)
                .collect(Collectors.toList());
    }
}
