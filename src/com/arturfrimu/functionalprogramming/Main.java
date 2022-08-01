package com.arturfrimu.functionalprogramming;

public class Main {
    public static void main(String[] args) {
        EmailValidator emailValidator = new EmailValidator();

        System.out.println(emailValidator.test("artur"));
        System.out.println(emailValidator.test("artur.frimu"));
        System.out.println(emailValidator.test("artur.frimu@"));
        System.out.println(emailValidator.test("artur.frimu@gmail"));

        System.out.println(emailValidator.test("artur.frimu@gmail.com"));
        System.out.println(emailValidator.test("artur.frimu@mail.ru"));
        System.out.println(emailValidator.test("artur.frimu@mail.en"));
        System.out.println(emailValidator.test("artur.frimu@mail.e"));
    }
}
