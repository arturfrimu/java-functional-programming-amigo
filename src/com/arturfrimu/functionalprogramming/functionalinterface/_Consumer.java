package com.arturfrimu.functionalprogramming.functionalinterface;

import com.arturfrimu.functionalprogramming.model.Customer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;


/**
 * Consumer takes 1 argument and return void
 * BiConsumer takes 2 arguments and return void
 */
public class _Consumer {
    public static void main(String[] args) {

        System.out.println("\tConsumer\n");

        greetCustomer(new Customer("Maria", "99999"));
        greetCustomerConsumer.accept(new Customer("Maria", "99999"));

        System.out.println("\n\tBiConsumer\n");

        greetCustomerV2(new Customer("Maria", "99999"), true);
        greetCustomerV2(new Customer("Maria", "99999"), false);

        greetCustomerBiConsumer.accept(new Customer("Maria", "99999"), true);
        greetCustomerBiConsumer.accept(new Customer("Maria", "99999"), false);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.getCustomerName() + ", thanks for registering phone number "
        + customer.getCustomerPhoneNumber());
    }

    static void greetCustomerV2(Customer customer, Boolean showPhoneNumber) {
        System.out.println("Hello " + customer.getCustomerName() + ", thanks for registering phone number "
                + (showPhoneNumber ? customer.getCustomerPhoneNumber() : "******"));
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.getCustomerName() + ", thanks for registering phone number "
                    + customer.getCustomerPhoneNumber());

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.getCustomerName() + ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.getCustomerPhoneNumber() : "******"));
}
