package stream;

import java.util.List;
import java.util.stream.Collectors;

import static stream._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );
        System.out.println("collect all entered genders into a list");
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("collect all entered genders into a set duplicates");
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet()) //no duplicates
                .forEach(System.out::println);

        System.out.println("collect all entered names into a set no duplicates");


        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet()) //no duplicates
                .forEach(System.out::println);

        System.out.println("length of each name");

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length) // name -> name.length
                .forEach(System.out::println);

        System.out.println("is it all females");

        System.out.println(people.stream()
                .allMatch(person -> person.gender.equals(FEMALE)));

        System.out.println("at least one female");

        System.out.println(people.stream()
                .anyMatch(person -> person.gender.equals(FEMALE)));

        System.out.println("no  PREFER_NOT_TO_SAY");

        System.out.println(people.stream()
                .noneMatch(person -> person.gender.equals(PREFER_NOT_TO_SAY)));
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
