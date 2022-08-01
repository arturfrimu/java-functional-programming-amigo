package com.arturfrimu.functionalprogramming.imperative;

import com.arturfrimu.functionalprogramming.model.Gender;
import com.arturfrimu.functionalprogramming.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.arturfrimu.functionalprogramming.model.Gender.FEMALE;
import static com.arturfrimu.functionalprogramming.model.Gender.MALE;

public class DifferentApproach {
    static List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
    );

    public static void main(String[] args) {
        // IMPERATIVE APPROACH
        ImperativeApproach imperative = new ImperativeApproach(people);
        List<Person> females = imperative.filterByGender(FEMALE);
        imperative.showPeople(females);

        System.out.println("\n");

        // DECLARATIVE APPROACH
        DeclarativeApproach declarative = new DeclarativeApproach(people);
        List<Person> _females = declarative.filterByGender(FEMALE);
        declarative.showPeople(_females);

        System.out.println("\n");

        // DECLARATIVE APPROACH
        List<Person> _females_ = people.stream()
                .filter(person -> FEMALE.equals(person.getGender()))
                .collect(Collectors.toList());
        _females_.forEach(System.out::println);

        System.out.println("\n");

        // DECLARATIVE APPROACH METHOD CHAINING
        people.stream()
                .filter(person -> FEMALE.equals(person.getGender()))
                .forEach(System.out::println);
    }

    static class ImperativeApproach {
        private final List<Person> people;

        ImperativeApproach(List<Person> people) {
            this.people = people;
        }

        public List<Person> filterByGender(Gender gender) {
            final List<Person> females = new ArrayList<>();

            for (Person person : people) {
                if (gender.equals(person.getGender())) {
                    females.add(person);
                }
            }
            return females;
        }

        public void showPeople(List<Person> people) {
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }

    static class DeclarativeApproach {
        private final List<Person> people;

        DeclarativeApproach(List<Person> people) {
            this.people = people;
        }

        public List<Person> filterByGender(Gender gender) {
            return people.stream().filter(person -> gender.equals(person.getGender()))
                    .collect(Collectors.toList());
        }

        public void showPeople(List<Person> people) {
            people.forEach(System.out::println);
        }
    }


}
