package com.arturfrimu.functionalprogramming.functionalinterface;

import com.arturfrimu.functionalprogramming.model.Person;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.arturfrimu.functionalprogramming.model.Gender.FEMALE;
import static com.arturfrimu.functionalprogramming.model.Gender.MALE;

/**
 * Predicate takes 1 argument and produces 1 boolean result
 * BiPredicate takes 2 arguments and produces 1 boolean result
 */
public class _Predicate {
    static List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
    );

    public static void main(String[] args) {
        Predicate<Person> filterFemales = person -> FEMALE.equals(person.getGender());
        Predicate<Person> filterStartWithA = person -> person.getName().startsWith("A");

        List<Person> females = people.stream()
                .filter(filterFemales)
                .filter(filterStartWithA)
                .collect(Collectors.toList());

        females.forEach(System.out::println);

        System.out.println("\n\tIMPERATIVE APPROACH\n");

        System.out.println(isPhoneNumberValid("07000000000")); // true
        System.out.println(isPhoneNumberValid("06000000000")); // false
        System.out.println(isPhoneNumberValid("0600000000"));  // false

        System.out.println("\n\tDECLARATIVE APPROACH\n");

        System.out.println(isPhoneNumberValidPredicate.test("07000000000")); // true
        System.out.println(isPhoneNumberValidPredicate.test("06000000000")); // false
        System.out.println(isPhoneNumberValidPredicate.test("0600000000"));  // false

        System.out.println("\n\tCHAINING WITH .and()\n");

        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3Predicate).test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3Predicate).test("07000000003"));

        System.out.println("\n\tCHAINING WITH .or()\n");

        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3Predicate).test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3Predicate).test("07000000003"));

        System.out.println("\n\tBiPredicate\n");

        System.out.println(containsPatternPredicate.test("07000000003", "070"));
        System.out.println(containsPatternPredicate.test("07000000003", "071"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber
            -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3Predicate = phoneNumber -> phoneNumber.contains("3");

    static BiPredicate<String, String> containsPatternPredicate = (phoneNumber, pattern) ->
            phoneNumber.contains(pattern);

}
