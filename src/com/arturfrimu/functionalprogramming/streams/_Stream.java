package com.arturfrimu.functionalprogramming.streams;

import com.arturfrimu.functionalprogramming.model.Person;

import java.util.List;
import java.util.stream.Collectors;

import static com.arturfrimu.functionalprogramming.model.Gender.FEMALE;
import static com.arturfrimu.functionalprogramming.model.Gender.MALE;

public class _Stream {
    static List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
    );

    public static void main(String[] args) {
        people.stream()
                .map(person -> person.getName())
                .mapToInt(String::length)
//                .forEach(System.out::println)
        ;

        System.out.println(people.stream().allMatch(person -> person.getName().startsWith("A")));
        System.out.println(people.stream().anyMatch(person -> person.getName().startsWith("A")));
        System.out.println(people.stream().filter(person -> person.getName().startsWith("A")).count());
        System.out.println(people.stream().filter(person -> person.getName().startsWith("A")).collect(Collectors.toList()));
        System.out.println(people.stream().filter(person -> person.getName().startsWith("A")).limit(2).collect(Collectors.toSet()));
        System.out.println(people.stream().filter(person -> person.getName().startsWith("A")).skip(1).collect(Collectors.toList()));
        System.out.println(people.stream().filter(person -> person.getName().startsWith("A")).findFirst());
    }
}
