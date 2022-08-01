package com.arturfrimu.functionalprogramming.combinator;

import java.time.LocalDate;

import static com.arturfrimu.functionalprogramming.combinator.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        CustomerValidatorService customerValidatorService = new CustomerValidatorService();

        Customer customer1 = new Customer("Alice", "alice@gmail.com", "+03807505903", LocalDate.of(2000, 1, 1));
        Customer customer2 = new Customer("Alice", "alicegmail.com", "+03807505903", LocalDate.of(2000, 1, 1));

        boolean isValidCustomer1 = customerValidatorService.isValid(customer1);
        System.out.println(isValidCustomer1);

        boolean isValidCustomer2 = customerValidatorService.isValid(customer2);
        System.out.println(isValidCustomer2);

        // USING COMBINATOR PATTERN

        ValidationResult result1 = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult()).apply(customer1);

        ValidationResult result2 = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult()).apply(customer2);

        System.out.println(result1);
        System.out.println(result2);

        if (result1 != ValidationResult.SUCCESS) throw new IllegalStateException(result1.name());
        if (result2 != ValidationResult.SUCCESS) throw new IllegalStateException(result2.name());
    }
}
